DEPENDS += "kern-tools-native xz-native bc-native lzop-native linux-firmware"

inherit kernel
inherit kernel-yocto

DEFAULT_PREFERENCE = "1"

PROVIDES += "virtual/kernel"

BRANCH = "linux-6.18.y"
LINUX_VERSION = "6.18.45"

PV = "${LINUX_VERSION}"
SRCREV = "v${LINUX_VERSION}-ts"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRC_URI = "git://github.com/embeddedTS/linux-lts.git;protocol=https;branch=${BRANCH}"

SUMMARY = "Linux kernel for eTS platforms"
DESCRIPTION = "Linux Kernel modified for TS board support."

COMPATIBLE_MACHINE = "(tsimx6|tsimx6ul|tsa38x)"

KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG:tsimx6 ?= "tsimx6_defconfig"
KBUILD_DEFCONFIG:tsimx6ul ?= "tsimx6ul_defconfig"
KBUILD_DEFCONFIG:tsa38x ?= "tsa38x_defconfig"
