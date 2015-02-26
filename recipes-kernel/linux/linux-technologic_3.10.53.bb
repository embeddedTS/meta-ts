# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-technologic.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_3.10.53_1.1.0_ga"
SRCREV = "6e2248524534aee501a62344d5601d104e2dda68"
LOCALVERSION = "-1.0.0-technologic"

COMPATIBLE_MACHINE = "(ts4900)"
