SUMMARY = "Start script for tssilomon"
DESCRIPTION = "TS-SILO's tssilomon script that monitors the supercaps and reboots when needed"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
# nooelint: oelint.var.licenseremotefile - No remote to fetch license from
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

SRC_URI = "file://tssilomon.service \
           file://tssilomon"
S = "${UNPACKDIR}"

inherit systemd update-rc.d

do_install() {
    if "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${UNPACKDIR}/tssilomon.service ${D}${systemd_unitdir}/system
        sed -i -e 's#@BINDIR@#${base_bindir}#g' ${D}${systemd_unitdir}/system/tssilomon.service
    elif ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0744 ${UNPACKDIR}/tssilomon ${D}${sysconfdir}/init.d/tssilomon
        sed -i -e 's#@BINDIR@#${base_bindir}#g' ${D}${sysconfdir}/init.d/tssilomon
    else
    bbwarn "Using neither systemd nor sysvinit for init system! tssilomon startup script will not be installed!"
    fi
}

FILES:${PN} += "/"

# These should do nothing if sysvinit is not defined as a DISTRO_FEATURE
INITSCRIPT_NAME = "tssilomon"
INITSCRIPT_PARAMS = "defaults 99"

# This should do nothing if systemd is not defined as a DISTRO_FEATURE
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "tssilomon.service"
SYSTEMD_AUTO_ENABLE = "enable"
