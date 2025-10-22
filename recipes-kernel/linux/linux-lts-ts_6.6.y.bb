SUMMARY = "Linux kernel for eTS platforms"
DESCRIPTION = "Linux Kernel modified for TS board support."
HOMEPAGE = "https://github.com/embeddedTS/linux-lts"
BUGTRACKER = "https://github.com/embeddedTS/linux-lts/issues"
SECTION = "bsp"

inherit kernel
inherit kernel-yocto

DEFAULT_PREFERENCE = "1"

BRANCH = "linux-6.6.y"
LINUX_VERSION = "6.6.112"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "bc-native kern-tools-native linux-firmware lzop-native xz-native"

PROVIDES += "virtual/kernel"
PV = "${LINUX_VERSION}"

SRC_URI = "git://github.com/embeddedTS/linux-lts.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${LINUX_VERSION}-ts"

COMPATIBLE_MACHINE = "(tsimx6|tsimx6ul|tsa38x)"

KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG:tsimx6 ?= "tsimx6_defconfig"
KBUILD_DEFCONFIG:tsimx6ul ?= "tsimx6ul_defconfig"
KBUILD_DEFCONFIG:tsa38x ?= "tsa38x_defconfig"
