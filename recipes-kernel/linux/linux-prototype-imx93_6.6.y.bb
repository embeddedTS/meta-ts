

DEPENDS += "kern-tools-native xz-native bc-native lzop-native linux-firmware"

inherit kernel
inherit kernel-yocto

DEFAULT_PREFERENCE = "1"

PROVIDES += "virtual/kernel"

BRANCH = "lf-6.6.y-ts"
LINUX_VERSION = "6.6.36"

PV = "${LINUX_VERSION}"
SRCREV = "39fcaa4cd050c4830cf378310af6670ad1e11fb8"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRC_URI = "git://github.com/embeddedTS/prototype-linux-imx93.git;protocol=https;branch=${BRANCH}"

SUMMARY = "Linux kernel for eTS i.MX93 platforms"
DESCRIPTION = "Linux Kernel modified for i.MX93 TS board support."

COMPATIBLE_MACHINE = "(tsimx93)"

KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG ?= "ts9370_defconfig"
