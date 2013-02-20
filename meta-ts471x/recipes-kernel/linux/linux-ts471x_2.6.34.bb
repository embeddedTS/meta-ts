DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

# Enable OABI compat for people stuck with obsolete userspace
ARM_KEEP_OABI ?= "1"

# Quirk for udev greater or equal 141
UDEV_GE_141 ?= "0"


DESCRIPTION = "Linux kernel for TS471x based boards"
KERNEL_IMAGETYPE = "zImage"

#DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "ts471x"
PR = "r1"
PV = "2.6.34"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/embeddedarm/linux-2.6.34-ts471x.git;protocol=git;tag=1b46ac4bd3e471989de3e6e18c822e97d7d84766 \
           "

kernel_do_configure_prepend() {
		cd ${S}
		make ts471x_defconfig
}

