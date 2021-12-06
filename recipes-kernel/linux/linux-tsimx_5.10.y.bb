DEPENDS += "kern-tools-native xz-native bc-native lzop-native linux-firmware"

inherit kernel
DEFAULT_PREFERENCE = "1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SCMVERSION ?= "y"
PV = "${LINUX_VERSION}+git${SRCPV}"
S = "${WORKDIR}/git"

SRCBRANCH = "linux-5.10.y"
KERNEL_SRC ?= "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
           file://0001-ARM-dts-TS-7970-updated-support.patch \
           file://0002-ARM-dts-Add-TS-7970-Rev.-F-PCB-support.patch"
LOCAL_VERSION = "-1.1"
SRCREV = "e4f2aee6612e56c2a9a5da6131ccd80e57d5075b"
LINUX_VERSION = "5.10.85"

# Install SDMA firmware in kernel
do_configure_prepend() {
   install -d ${S}/firmware/imx/sdma/ || die "could not make directory"
   install -m 644 ${STAGING_BASELIBDIR}/firmware/imx/sdma/sdma-imx6q.bin ${S}/firmware/imx/sdma/ || die "could not copy sdma firmware"
}


SUMMARY = "Linux kernel for TS IMX based Boards"
DESCRIPTION = "Linux Kernel modified for TS board support."

COMPATIBLE_MACHINE = "(tsimx6)"


# From meta-freescale recipes-kernel linux-imx.inc
#
# Tell to kernel class that we would like to use our defconfig to configure the kernel.
# Otherwise, the --allnoconfig would be used per default which leads to mis-configured
# kernel.
#
# This behavior happens when a defconfig is provided, the kernel-yocto configuration
# uses the filename as a trigger to use a 'allnoconfig' baseline before merging
# the defconfig into the build.
#
# If the defconfig file was created with make_savedefconfig, not all options are
# specified, and should be restored with their defaults, not set to 'n'.
# To properly expand a defconfig like this, we need to specify: KCONFIG_MODE="--alldefconfig"
# in the kernel recipe include.
KCONFIG_MODE="--alldefconfig"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
