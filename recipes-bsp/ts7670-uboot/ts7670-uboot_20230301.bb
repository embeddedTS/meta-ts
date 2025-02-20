SUMMARY = "TS-7670 U-Boot blob"
HOMEPAGE = "http://www.embeddedTS.com/"

COMPATIBLE_MACHINE = "ts7670"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "https://files.embeddedts.com/ts-arm-sbc/ts-7670-linux/binaries/u-boot/ts7670-${PV}.sd"
SRC_URI[sha256sum] = "84f15ebb83b5711e827d2d20aba4cdab7b8f8907d82941ebc685a86892a12a0a"

S = "${WORKDIR}"

inherit deploy

do_install() {
    :
}

do_deploy() {
    install -d "${DEPLOYDIR}/uboot/"
    install -m 0644 "${WORKDIR}/ts7670-${PV}.sd" "${DEPLOYDIR}/uboot/uboot.sd"
}

addtask deploy after do_fetch
