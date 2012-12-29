DESCRIPTION = "Technologic Systems misc modificationis"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r6"

S = "${WORKDIR}"
FILES_${PN} = "/"

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}/dev
	install -d ${D}/dev/pts
	install -m 0755 -d ${D}/initrd

	ln -s /initrd/slib ${D}/slib
	ln -s /initrd/sbin/canctl ${D}${sbindir}/canctl
	ln -s /initrd/sbin/daqctl ${D}${sbindir}/daqctl
	ln -s /initrd/sbin/dioctl ${D}${sbindir}/dioctl
	ln -s /initrd/sbin/dmxctl ${D}${sbindir}/dmxctl
	ln -s /initrd/sbin/nandctl ${D}${sbindir}/nandctl
	ln -s /initrd/sbin/sdctl ${D}${sbindir}/sdctl
	ln -s /initrd/sbin/spictl ${D}${sbindir}/spictl
	ln -s /initrd/sbin/spiflashctl ${D}${sbindir}/spiflashctl
	ln -s /initrd/sbin/ts7500ctl ${D}${sbindir}/ts7500ctl
	ln -s /initrd/sbin/xuartctl ${D}${sbindir}/xuartctl

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
