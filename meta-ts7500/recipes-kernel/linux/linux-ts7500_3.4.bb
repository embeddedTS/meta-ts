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
PR = "r3"
PV = "3.4"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/embeddedarm/linux-3.4-ts75xx.git;protocol=git;tag=828afabd21f83d548ac588e11b66e82d671e04fe \
	   file://defconfig \
           "

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

