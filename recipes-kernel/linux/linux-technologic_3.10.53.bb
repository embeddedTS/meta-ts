# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-technologic.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_3.10.53_1.1.0_ga"
SRCREV = "34c7a3086e08eaa1f6461a2c56c2961aba439e0e"
LOCALVERSION = "-1.0.0-technologic"

COMPATIBLE_MACHINE = "(ts4900)"

do_shared_workdir () {
	:
}

addtask shared_workdir after do_compile before do_install
