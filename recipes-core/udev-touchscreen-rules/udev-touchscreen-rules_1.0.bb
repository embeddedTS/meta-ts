SUMMARY = "embeddedTS Touchscreen udev rules"
DESCRIPTION = "udev rules for embeddedTS TPC platforms with resistive touchscreens"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "base"
LICENSE = "MIT"

# nooelint: oelint.var.licenseremotefile - No remote to fetch license from
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "ts4900|ts7100|ts7990"

SRC_URI:ts4900 += "\
    file://99-ts4900-8390-resistive-touchscreen.rules \
    file://99-ts4900-8950-resistive-touchscreen.rules \
"
SRC_URI:ts7100 += "file://99-ts7100-resistive-touchscreen.rules"
SRC_URI:ts7990 += "file://99-ts7990-resistive-touchscreen.rules"
S = "${UNPACKDIR}"

do_install () {
    install -d "${D}${sysconfdir}/udev/rules.d/"

    for I in ${UNPACKDIR}/*${MACHINE}*; do
        if [ -f "${I}" ]; then
            install -m 0644 "${I}" \
                "${D}${sysconfdir}/udev/rules.d/"
        fi
    done
}
