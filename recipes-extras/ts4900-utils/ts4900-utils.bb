SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master \
           file://tssilomon.service"
SRCREV = "c56c41db10692cf4c6677092ff97cb64dfca3015"
PV = "1.0.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools systemd

do_install_append() {
    install -m 0755 ${S}/script/tssilomon ${D}${bindir}
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/tssilomon.service ${D}${systemd_unitdir}/system

        sed -i -e 's#@BINDIR@#${bindir}#g' ${D}${systemd_unitdir}/system/tssilomon.service
    fi
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "tssilomon.service"
SYSTEMD_AUTO_ENABLE = "enable"
