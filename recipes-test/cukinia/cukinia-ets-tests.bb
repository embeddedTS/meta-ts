SUMMARY = "cukinia tests and startup files for meta-ts image verification"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

SRC_URI = " \
    file://common.conf \
    file://cukinia.conf \
    file://tssilomon.conf \
    file://cukinia \
    file://cukinia.service \
"

RDEPENDS:${PN} = "cukinia"

inherit systemd update-rc.d

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install:append() {
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/cukinia.d

    install -m 0644 ${UNPACKDIR}/common.conf ${D}${sysconfdir}/cukinia.d/
    install -m 0644 ${UNPACKDIR}/tssilomon.conf ${D}${sysconfdir}/cukinia.d/
    install -m 0644 ${UNPACKDIR}/cukinia.conf ${D}${sysconfdir}
    if "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${UNPACKDIR}/cukinia.service ${D}${systemd_unitdir}/system
    elif ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0744 ${UNPACKDIR}/cukinia ${D}${sysconfdir}/init.d/cukinia
    fi
}

FILES:${PN} += "${sysconfdir}"

# These should do nothing if sysvinit is not defined as a DISTRO_FEATURE
INITSCRIPT_NAME = "cukinia"
INITSCRIPT_PARAMS = "defaults 99"

# This should do nothing if systemd is not defined as a DISTRO_FEATURE
SYSTEMD_SERVICE:${PN} = "cukinia.service"
