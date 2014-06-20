# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dtb.inc
include linux-technologic.inc

DEPENDS += "lzop-native bc-native"

# TS branch - based on 3.10.17_1.0.0_ga from Freescale git
SRCBRANCH = "master"
SRCREV = "master"
LOCALVERSION = "-1.0.0-technologic"

COMPATIBLE_MACHINE = "(ts4900)"
