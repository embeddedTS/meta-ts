DESCRIPTION="External module for WILC3000 WiFi/BLE"
HOMEPAGE="https://github.com/embeddedTS/wilc3000-external-module/"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM="file://LICENSE;md5=e6a75371ba4d16749254a51215d13f97"

BRANCH = "2024.04-with-community-patches"

SRC_URI = "git://github.com/embeddedTS/wilc3000-external-module.git;protocol=https;branch=${BRANCH}"
SRCREV = "1e056e47144b8896a6a79204d128b529a5bd0b0f"

S = "${WORKDIR}/git"

# Set the build dir to the kernel source dir. Normally, the module class in
# yocto expects the external module sources to have a Makefile available in.
# This external module only uses Kbuild which yocto doesn't seem to understand.
# By setting the build dir to kernel source dir, the make commands below are
# executed against the kernel's Makefile which understands how to build external
# modules like this.
B = "${STAGING_KERNEL_DIR}"

inherit module

do_compile() {
	export CONFIG_WILC_SPI=m
	make M="${S}" modules
}

do_install() {
	export CONFIG_WILC_SPI=m
	make M="${S}" INSTALL_MOD_PATH="${D}" modules_install
}
