DESCRIPTION="External module for WILC3000 WiFi/BLE"
HOMEPAGE="https://github.com/embeddedTS/wilc3000-external-module/"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM="file://LICENSE;md5=e6a75371ba4d16749254a51215d13f97"

BRANCH = "2024.04-with-community-patches"

SRC_URI = "git://github.com/embeddedTS/wilc3000-external-module.git;protocol=https;branch=${BRANCH}"
SRCREV = "1e056e47144b8896a6a79204d128b529a5bd0b0f"

S = "${WORKDIR}/git"

inherit module

# Set the build dir to the kernel source dir. Normally, the module class in
# yocto expects the external module sources to have a Makefile available in it.
# This external module only uses Kbuild which yocto doesn't seem to understand.
# By setting the build dir to kernel source dir, the make commands below are
# executed against the kernel's Makefile which understands how to build external
# modules like this.
B = "${STAGING_KERNEL_BUILDDIR}"

DEPENDS = "virtual/kernel"

EXTRA_OEMAKE:append = " \
    KERNEL_DIR=${STAGING_KERNEL_DIR} \
    M=${S} \
    INSTALL_MOD_PATH=${D}${root_prefix} \
    CONFIG_WILC_SPI=m \
"

FILES:${PN} += "${nonarch_base_libdir}/modules"

RDEPENDS:${PN} = "wilc3000-firmware"

# Using the module bbclass bring in kernel-module-split which then transforms
# each kermel module in to its own package. e.g. kernel-module-wilc-spi with
# the name being derived from the actual kernel module being built. This name
# should be automatically added to the providers of this recipe, but isn't.
# So, manually specify the kernel module actually being provided by this.
RPROVIDES:${PN} += "kernel-module-wilc-spi-${KERNEL_VERSION}"
