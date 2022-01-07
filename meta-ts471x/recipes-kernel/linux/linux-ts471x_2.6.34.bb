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
PR = "r0"
PV = "2.6.34"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/embeddedTS/linux-2.6.34-ts471x.git;protocol=git;tag=c3de2e89f23d328e99253b2320efd8944e524b08 \
	   file://defconfig \
	   file://initramfs.tar.bz2 \
           "

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

