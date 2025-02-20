SUMMARY = "TS-7400-V2 U-Boot blob"
HOMEPAGE = "http://www.embeddedTS.com/"

COMPATIBLE_MACHINE = "ts7400v2"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "https://files.embeddedts.com/ts-arm-sbc/ts-7400_V2-linux/binaries/u-boot/ts7400v2-${PV}.sd"
SRC_URI[sha256sum] = "2573f4420f9863ece2c40dcf3a4b9d51b77a04f37c80503b45f10c372747b3ad"

S = "${WORKDIR}"

inherit deploy

do_install() {
    :
}

do_deploy() {
    install -d "${DEPLOYDIR}/uboot/"
    install -m 0644 "${WORKDIR}/ts7400v2-${PV}.sd" "${DEPLOYDIR}/uboot/uboot.sd"
}

addtask deploy after do_fetch
