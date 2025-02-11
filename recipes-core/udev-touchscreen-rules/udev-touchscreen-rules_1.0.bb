DESCRIPTION = "udev rules for embeddedTS TPC platforms with resistive touchscreens"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "ts4900|ts7100|ts7990"

SRC_URI:append:ts4900 = " \
	file://99-ts4900-8390-resistive-touchscreen.rules \
	file://99-ts4900-8950-resistive-touchscreen.rules \
"
SRC_URI:append:ts7100 = " file://99-ts7100-resistive-touchscreen.rules"
SRC_URI:append:ts7990 = " file://99-ts7990-resistive-touchscreen.rules"

do_install () {
	install -d "${D}${sysconfdir}/udev/rules.d/"

	for I in ${WORKDIR}/*${MACHINE}*; do
		if [ -f "${I}" ]; then
			install -m 0644 "${I}" \
				"${D}${sysconfdir}/udev/rules.d/"
		fi
	done
}
