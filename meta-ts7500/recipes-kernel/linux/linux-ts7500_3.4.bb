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
PR = "r1"
PV = "3.4"

S = "${WORKDIR}/linux-${PV}-ts43xx"

SRCREV = "${AUTOREV}"
SRC_URI = "ftp://oz.embeddedarm.com/ts-socket-macrocontrollers/ts-4300-linux/sources/linux-3.4-ts43xx-latest.tar.gz \
	   file://defconfig \
           "
SRC_URI[md5sum] = "20a9d43842ee2f7564cd4af2a09543ad"
SRC_URI[sha256sum] = "9d565c2172c39e23b6b45f7b73bcfc8cd0e9a09ffb4e5f24b1e3d34335534c1c"

kernel_do_configure_prepend() {
                cp "${WORKDIR}/defconfig" "${B}/.config"
}

