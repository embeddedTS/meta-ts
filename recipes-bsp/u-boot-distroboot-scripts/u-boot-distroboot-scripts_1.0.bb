SUMMARY = "U-Boot scripts for distroboot compatible embeddedTS platforms"
HOMEPAGE = "http://www.embeddedTS.com/"

COMPATIBLE_MACHINE = "(ts7100|ts7250v3)"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

DEPENDS += "u-boot-mkimage-native"
S = "${UNPACKDIR}"

SRC_URI = "file://boot-${MACHINE}.source"

# Note that, if using custom U-Boot scripts on _any_ platform, it should possible
# to extend this with a .bbappend file to add additional files to be considered
# so long as they are named "boot-<machine>.source" and the machine is expecting
# a script name /boot/boot.scr
do_compile () {
    if [ -f "${S}/boot-${MACHINE}.source" ]; then
        cp "${S}/boot-${MACHINE}.source" "${S}/boot.source"
        mkimage -A arm -T script -C none -n 'boot' \
            -d "${S}/boot.source" "${S}/boot.scr"
    else
        bbfatal "Missing script source: ${S}/boot-${MACHINE}.source"
    fi
}

do_install () {
    install -d "${D}/boot"
    install -m 0644 "${S}/boot.scr" "${D}/boot/"
}

FILES:${PN} += "/boot/boot.scr"
