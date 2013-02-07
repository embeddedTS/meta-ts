DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

# Enable OABI compat for people stuck with obsolete userspace
ARM_KEEP_OABI ?= "1"

# Quirk for udev greater or equal 141
UDEV_GE_141 ?= "0"


DESCRIPTION = "Linux kernel for TS7500 based boards"
KERNEL_IMAGETYPE = "zImage"

#DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "ts7500"
PR = "r4"
PV = "3.4"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/embeddedarm/linux-3.4-ts75xx.git;protocol=git;tag=6e4f4065217d14ff6c4dfb6c1b6d1371638fe63b \
	   file://defconfig \
           "

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

