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

COMPATIBLE_MACHINE = "ts4800"
PR = "r0"
PV = "2.6.35"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/embeddedTS/linux-2.6.35-ts4800.git;protocol=git;tag=b0449eee2fd74e389c29c4479c221c545efe8ecc \
	   file://defconfig \
           "

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

