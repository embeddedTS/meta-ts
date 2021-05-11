FILESEXTRAPATHS_prepend := "${THISDIR}/:"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://TIInit_7.6.15.bts"
SRC_URI += "file://wl127x-nvs.bin"
SRC_URI += "file://wilc1000_wifi_firmware.bin"
SRC_URI += "file://wilc3000_bt_firmware.bin"
SRC_URI += "file://wilc3000_bt_firmware_no_rtc.bin"
SRC_URI += "file://wilc3000_wifi_firmware.bin"
SRC_URI += "file://wilc3000_ble_firmware.bin"
SRC_URI += "file://wilc3000_ble_firmware_no_rtc.bin"
SRC_URI += "file://wilc.conf"

do_install_append() {
    install -d ${D}/lib/firmware/
    install -d ${D}/lib/firmware/ti-connectivity/
    install -m 0444 ${WORKDIR}/TIInit_7.6.15.bts ${D}/lib/firmware/ti-connectivity/
    install -m 0444 ${WORKDIR}/wl127x-nvs.bin ${D}/lib/firmware/ti-connectivity/

    install -d ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc1000_wifi_firmware.bin ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc3000_bt_firmware.bin ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc3000_bt_firmware_no_rtc.bin ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc3000_wifi_firmware.bin ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc3000_ble_firmware.bin ${D}/lib/firmware/mchp/
    install -m 0444 ${WORKDIR}/wilc3000_ble_firmware_no_rtc.bin ${D}/lib/firmware/mchp/

    install -d ${D}/etc/modules-load.d/
    install -m 0644 ${WORKDIR}/wilc.conf ${D}/etc/modules-load.d/
}
