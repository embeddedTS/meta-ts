# adapted from linux-imx.inc, copyright (C) 2016-2022 Technologic Systems, Inc. dba embeddedTS
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for TS IMX6 Boards"
DESCRIPTION = "Linux Kernel based on linux-imx modified for TS board support."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_4.1.15_1.0.0_ga"
LOCALVERSION = "-1.0.0-technologic"
SRCREV = "7a90b5feb65ba5f0d1e71bbb041ff85f683bce16"

SRC_URI = "git://github.com/embeddedTS/linux-3.10.17-imx6.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"
