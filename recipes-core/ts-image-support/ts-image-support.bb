DESCRIPTION = "Technologic Systems support files to build bootable image(mbr, initrd)"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"
S = "${WORKDIR}"
#FILES_${PN} = "/boot"

SRC_URI += " file://vfatdummy.dd.bz2 "

do_install() {
	install -d ${D}${datadir}
	install -d ${D}${datadir}/ts-image-support
	install -m 644 ${S}/*.dd ${D}${datadir}/ts-image-support 
}

