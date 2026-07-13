SUMMARY = "Prebuilt toolchain for armhf hosts targeting the ZPU architecture"
DESCRIPTION = "Built from the original project repo source, this is a pre-compiled toolchain meant to build for ZPU targets from an armhf host that is hosted from our FTP servers."
HOMEPAGE = "https://github.com/zylin/zpugcc"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://files.embeddedts.com/ts-socket-macrocontrollers/ts-4100-linux/zpu/armhf-zpu-elf-gcc-${PV}.tar.bz2;subdir=${BP}"
SRC_URI[sha256sum] = "a0a2c143260a31796637ac3643b0cd661716447c4a20319d570d66b56fe5eb53"

do_install() {
	install -d "${D}/opt/zpu-elf-gcc/"
	cp -r "${S}"/* "${D}/opt/zpu-elf-gcc/"
}

FILES:${PN} += "/opt/zpu-elf-gcc"

# Since the toolchain includes ZPU ELF objects, we need to prevent the build
# system from attempting to strip/split debug symbols on these objects
# Additionally, on the files it can understand, it uses an older 32bit time
# API as well as static libraries. In theory, using FILES:${PN}-staticdev might
# be the correct way to handle this check, however, as this is not something we
# are building and its a self-contained toolchain, lets just bypass the check.
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP:${PN} = "32bit-time arch staticdev"
