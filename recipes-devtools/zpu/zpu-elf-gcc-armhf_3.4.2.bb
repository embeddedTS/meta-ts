SUMMARY = "Prebuilt toolchain for armhf hosts targeting the ZPU architecture"
DESCRIPTION = "Built from the original project repo source, this is a pre-compiled toolchain meant to build for ZPU targets from an armhf host that is hosted from our FTP servers."
HOMEPAGE = "https://github.com/zylin/zpugcc"
SECTION = "devel"
LICENSE = "GPL-2.0-only"
# nooelint: oelint.var.licenseremotefile - No remote to fetch license from
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://files.embeddedts.com/ts-socket-macrocontrollers/ts-4100-linux/zpu/armhf-zpu-elf-gcc-${PV}.tar.bz2"
SRC_URI[sha256sum] = "a0a2c143260a31796637ac3643b0cd661716447c4a20319d570d66b56fe5eb53"
S = "${UNPACKDIR}"

do_unpack() {
    # For _some_ reason, the default do_unpack extracts the tarball to
    # ${UNPACKDIR}/ instead of ${S}/ (which would default to
    # ${UNPACKDIR}/${PN}-${PV}). So we need to write our own custom unpack task
    # just to do the thing that should already be done.
    # Much of the complexty of this comes from the fact that Yocto _really_
    # likes to have names match when that doesn't make sense in the case of
    # this. e.g. their naming also wants to enforce -native in the .bb name
    # to note that it is for the host. The naming of the tarball and the first
    # folder of it prepends the arch rather than appending it. So, if we strip
    # the root folder of the tarball when we unpack it to ${S}, we should
    # finally be able to just copy the contents of ${S} to have the structure
    # we need.
    tar xhf "${DL_DIR}/$(basename "${SRC_URI}")" --strip-components=1 -C "${S}"
}

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

# nooelint: oelint.vars.insaneskip - Needed since this wont be getting updates
INSANE_SKIP:${PN} = "32bit-time arch staticdev"
