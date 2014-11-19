# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-technologic.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# TS branch - based on 3.10.17_1.0.0_ga from Freescale git
SRCBRANCH = "master"
SRCREV = "2b1cdafadf0747e8264a36face48bfa387e1e76e"
LOCALVERSION = "-1.0.0-technologic"

COMPATIBLE_MACHINE = "(ts4900)"