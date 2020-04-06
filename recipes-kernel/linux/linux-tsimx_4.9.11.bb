require recipes-kernel/linux/linux-imx.inc

DEPENDS += "kern-tools-native xz-native bc-native lzop-native"

inherit kernel
DEFAULT_PREFERENCE = "1"

SRCBRANCH = "ts-imx_4.9.11_1.0.0_ga"
KERNEL_SRC ?= "git://github.com/embeddedarm/linux-tsimx.git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "cdcfd0831e1c67d982a98741ae92bef9ac766aaf"
KERNEL_DEFCONFIG = "${S}/arch/arm/configs/ts4900_defconfig"

do_preconfigure_prepend() {
   cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
}

SUMMARY = "Linux kernel for TS IMX based Boards"
DESCRIPTION = "Linux Kernel modified for TS board support."

COMPATIBLE_MACHINE = "(tsimx6)"
