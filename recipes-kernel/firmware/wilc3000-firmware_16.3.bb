SUMMARY = "Firmware for WILC3000 WiFi/BLE devices"
HOMEPAGE = "https://github.com/linux4wilc/firmware"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.wilc_fw;md5=89ed0ff0e98ce1c58747e9a39183cc9f"

TAG = "wilc_linux_16_3"

PV = "${TAG}"
SRC_URI = "git://github.com/linux4wilc/firmware.git;protocol=https;branch=master"
SRCREV = "${TAG}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/mchp/
    install -m 0644 ${S}/wilc3000_wifi_firmware.bin ${D}${nonarch_base_libdir}/firmware/mchp/
    install -m 0644 ${S}/wilc3000_ble_firmware.bin ${D}${nonarch_base_libdir}/firmware/mchp/
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/mchp"
