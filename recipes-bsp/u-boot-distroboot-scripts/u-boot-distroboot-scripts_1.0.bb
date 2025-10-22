SUMMARY = "U-Boot scripts for distroboot compatible embeddedTS platforms"
DESCRIPTION = "Builds a machine-specific U-Boot script (boot.scr) from \
               boot-<machine>.source for distroboot-compatible embeddedTS \
               boards."
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
# nooelint: oelint.var.licenseremotefile - No remote to fetch license from
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

DEPENDS += "u-boot-mkimage-native"
SRC_URI = "file://boot.source"
S = "${UNPACKDIR}"

# Note that, if using custom U-Boot scripts on _any_ platform, it should possible
# to extend this with a .bbappend file to add additional files to be considered
# so long as they are named "boot-<machine>.source" and the machine is expecting
# a script name /boot/boot.scr
do_compile () {
    mkimage -A arm -T script -C none -n 'boot' \
        -d "${S}/boot.source" "${S}/boot.scr"
}

do_install () {
    install -d "${D}/boot"
    install -m 0644 "${S}/boot.scr" "${D}/boot/"
}

FILES:${PN} += "/boot/boot.scr"
