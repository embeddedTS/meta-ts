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

PV = "3.4"

S = "${WORKDIR}/linux-${PV}"

SRCREV = "${AUTOREV}"
SRC_URI = "ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/sources/linux-3.4.0-jul232012.tar.gz \
	   file://defconfig \
           "
SRC_URI[md5sum] = "cbdc9560aa25b1ac1a409056924e4b52"
SRC_URI[sha256sum] = "d82a0780d05af98116ee191b97ffa3fed3e102af03e60d6ef73624062a23accb"

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

