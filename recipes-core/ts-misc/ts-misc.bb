DESCRIPTION = "Technologic Systems misc modificationis"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r6"

S = "${WORKDIR}"
FILES_${PN} = "/"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}/dev
	install -d ${D}/dev/pts
	install -m 0755 -d ${D}/initrd

	ln -s /initrd/slib ${D}/slib
	ln -s /initrd/sbin/canctl ${D}${bindir}/canctl
	ln -s /initrd/sbin/daqctl ${D}${bindir}/daqctl
	ln -s /initrd/sbin/dioctl ${D}${bindir}/dioctl
	ln -s /initrd/sbin/dmxctl ${D}${bindir}/dmxctl
	ln -s /initrd/sbin/nandctl ${D}${bindir}/nandctl
	ln -s /initrd/sbin/sdctl ${D}${bindir}/sdctl
	ln -s /initrd/sbin/spictl ${D}${bindir}/spictl
	ln -s /initrd/sbin/spiflashctl ${D}${bindir}/spiflashctl
	ln -s /initrd/sbin/ts7500ctl ${D}${bindir}/ts7500ctl
	ln -s /initrd/sbin/xuartctl ${D}${bindir}/xuartctl

	test -c ${D}/dev/ptmx || mknod -m 666 ${D}/dev/ptmx c 5 2

}

pkg_postinst_${PN} () {
     #!/bin/sh -e
     if [ x"$D" = "x" ]; then
	ldconfig /slib
     else
          exit 1
     fi


}
