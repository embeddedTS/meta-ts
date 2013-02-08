DESCRIPTION = "Technologic Systems misc modificationis"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r8"

S = "${WORKDIR}"
FILES_${PN} = "/"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}/dev
	install -d ${D}/dev/pts
	install -m 0755 -d ${D}/initrd
	install -m 0755 -d ${D}/ts

	ln -s /initrd/sbin ${D}/ts/bin
	ln -s /initrd/slib ${D}/ts/slib

	ln -s /ts/slib ${D}/slib
	ln -s /ts/bin/canctl ${D}${bindir}/canctl
	ln -s /ts/bin/daqctl ${D}${bindir}/daqctl
	ln -s /ts/bin/dioctl ${D}${bindir}/dioctl
	ln -s /ts/bin/dmxctl ${D}${bindir}/dmxctl
	ln -s /ts/bin/nandctl ${D}${bindir}/nandctl
	ln -s /ts/bin/sdctl ${D}${bindir}/sdctl
	ln -s /ts/bin/spictl ${D}${bindir}/spictl
	ln -s /ts/bin/spiflashctl ${D}${bindir}/spiflashctl
	ln -s /ts/bin/ts7500ctl ${D}${bindir}/ts7500ctl
	ln -s /ts/bin/ts4700ctl ${D}${bindir}/ts4700ctl
	ln -s /ts/bin/xuartctl ${D}${bindir}/xuartctl

	test -c ${D}/dev/ptmx || mknod -m 666 ${D}/dev/ptmx c 5 2

}

pkg_postinst_${PN} () {
     #!/bin/sh -e
     if [ x"$D" = "x" ]; then
	ldconfig /slib
	update-rc.d -f hostapd remove
     else
          exit 1
     fi


}
