# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for TS IMX6 Boards"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# Put a local version until we have a true SRCREV to point to
LOCALVERSION ?= "+yocto"

SRCBRANCH ??= "imx_3.10.53_1.1.0_ga"
SRC_URI = "git://github.com/embeddedarm/linux-3.10.17-imx6.git;branch=${SRCBRANCH} \
           file://defconfig"

DEPENDS += "lzop-native bc-native"
SRCREV = "9516cbe97fd720087e70c320321d713841e030f8"
LOCALVERSION = "-1.1.0-technologic"

COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(tsimx6)"
