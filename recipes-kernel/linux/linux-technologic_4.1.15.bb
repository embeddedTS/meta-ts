# adapted from linux-imx.inc, copyright (C) 2016 Technologic Systems
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for TS IMX6 Boards"
DESCRIPTION = "Linux Kernel based on linux-imx modified for TS board support."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_4.1.15_1.0.0_ga"
LOCALVERSION = "-1.0.0-technologic"
SRCREV = "fba9dcde72bf6e7ea8acad56e375a9581805dfa9"

SRC_URI = "git://github.com/embeddedarm/linux-3.10.17-imx6.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"
