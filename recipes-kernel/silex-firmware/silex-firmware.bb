SUMMARY = "Silex SDMAC+ Firmware"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://${WORKDIR}/files/LICENSE.silex;md5=2b967ecddccf559405a6eb0d9035c397"

SRC_URI = "file://files/"
FILESEXTRAPATHS_prepend := "${THISDIR}/:"

#S = "${WORKDIR}"
FILES_${PN} =  "/lib/firmware/*"

do_install() {
    install -d ${D}/lib/firmware/wlan
    install -d ${D}/lib/firmware/qca

    install -m 0444 ${WORKDIR}/files/bdata_SX-SDMAC_20161113.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/2017-09-19_bdata_SX-SDMAC-2832S+.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/2017-09-19_bdata_SX-SDMAC-2832S.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/bdata_SX-SDMAC_20161113.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/bdwlan30.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/LICENSE.silex ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/otp30.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/qwlan30.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/utf30.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/WM-BAC-AT-09.bin ${D}/lib/firmware/
    install -m 0444 ${WORKDIR}/files/qca/nvm_tlv_tf_1.1_20160918.bin ${D}/lib/firmware/qca/
    install -m 0444 ${WORKDIR}/files/qca/nvm_tlv_tf_1.1.bin.qca.default ${D}/lib/firmware/qca/
    install -m 0444 ${WORKDIR}/files/qca/rampatch_tlv_tf_1.1_bt4-1.tlv ${D}/lib/firmware/qca/
    install -m 0444 ${WORKDIR}/files/qca/rampatch_tlv_tf_1.1_bt4-2.tlv ${D}/lib/firmware/qca/
    install -m 0444 ${WORKDIR}/files/qca/rampatch_tlv_tf_1.1.tlv ${D}/lib/firmware/qca/
    install -m 0444 ${WORKDIR}/files/wlan/cfg.dat ${D}/lib/firmware/wlan/
    install -m 0444 ${WORKDIR}/files/wlan/qcom_cfg.ini ${D}/lib/firmware/wlan/
}
