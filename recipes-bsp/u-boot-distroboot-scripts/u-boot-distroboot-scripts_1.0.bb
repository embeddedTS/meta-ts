SUMMARY = "U-Boot scripts for distroboot compatible embeddedTS platforms"
HOMEPAGE = "http://www.embeddedTS.com/"

COMPATIBLE_MACHINE = "(ts7100|ts7250v3|ts7840)"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

DEPENDS += "u-boot-mkimage-native"

SRC_URI = "\
    file://boot-ts7100.source \
    file://boot-ts7250v3.source \
    file://boot-ts7840.source \
"

# Note that, if using custom U-Boot scripts on _any_ platform, it should possible
# to extend this with a .bbappend file to add additional files to be considered
# so long as they are named "boot-<machine>.source" and the machine is expecting
# a script name /boot/boot.scr
do_compile () {
	if [ -f "${WORKDIR}/boot-${MACHINE}.source" ]; then
		cp "${WORKDIR}/boot-${MACHINE}.source" "${S}/boot.source"
		uboot-mkimage -A arm -T script -C none -n 'boot' \
			-d "${S}/boot.source" "${S}/boot.scr"
	else
		bbwarn "Unable to find matching U-Boot script file!"
	fi
}

do_install () {
	install -d "${D}/boot"
	install -m 0644 "${S}/boot.scr" "${D}/boot/"
}

FILES:${PN} += "/boot/boot.scr"
