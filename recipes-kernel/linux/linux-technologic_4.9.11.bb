# adapted from linux-imx.inc, copyright (C) 2016 Technologic Systems
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for TS IMX6 Boards"
DESCRIPTION = "Linux Kernel based on linux-imx modified for TS board support."
DEPENDS += "lzop-native bc-native"
SRCBRANCH = "ts-imx_4.9.11_1.0.0_ga"
LOCALVERSION = "-1.0.0-technologic"
SRCREV = "4b5f977f93b2f2defbe203e0c696c3b97adc0cc9"
SRC_URI = "git://github.com/embeddedarm/linux-tsimx.git;branch=${SRCBRANCH} \
           file://defconfig"
COMPATIBLE_MACHINE = "(tsimx6)"
