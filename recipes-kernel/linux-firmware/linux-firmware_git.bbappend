FILESEXTRAPATHS_prepend := "${THISDIR}/:"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://TIInit_7.6.15.bts"
SRC_URI += "file://wl1271-nvs.bin"

do_install_append() {
    install -d ${D}/lib/firmware/
    install -d ${D}/lib/firmware/ti-connectivity/
    install -m 0755 ${WORKDIR}/TIInit_7.6.15.bts ${D}/lib/firmware/
    install -m 0755 ${WORKDIR}/wl1271-nvs.bin ${D}/lib/firmware/ti-connectivity/
}
