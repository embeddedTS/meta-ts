SUMMARY = "Prebuilt toolchain for x86_64 hosts targeting the ZPU architecture"
DESCRIPTION = "Built from the original project repo source, this is a pre-compiled toolchain meant to build for ZPU targets from an x86_64 host that is hosted from our FTP servers."
HOMEPAGE = "https://github.com/zylin/zpugcc"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit native

SRC_URI = "https://files.embeddedts.com/ts-socket-macrocontrollers/ts-4100-linux/zpu/x86_64-zpu-elf-gcc-${PV}.tar.bz2;subdir=${BP}"
SRC_URI[sha256sum] = "cf85d22d469bbbd89c02f22707e923aa1febc21180ad0467cd24602d9e3e3613"

do_install() {
	if [ "${BUILD_ARCH}" = "x86_64" ] ; then
		install -d "${D}/${bindir}/zpu-elf-gcc/"
		cp -r "${S}"/* "${D}/${bindir}/zpu-elf-gcc/"
	else
		bbwarn "Native ZPU toolchain only supports x86_64 build environments. Detected build architecture: ${BUILD_ARCH}. ZPU toolchain will not be available for other recipes!"
	fi
}

FILES:${PN} += "/${bindir}/zpu-elf-gcc"

# Since the toolchain includes ZPU ELF objects, we need to prevent the build
# system from attempting to strip/split debug symbols on these objects
# Additionally, on the files it can understand, it uses an older 32bit time
# API as well as static libraries. In theory, using FILES:${PN}-staticdev might
# be the correct way to handle this check, however, as this is not something we
# are building and its a self-contained toolchain, lets just bypass the check.
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP:${PN} = "32bit-time arch file-rdeps staticdev"
