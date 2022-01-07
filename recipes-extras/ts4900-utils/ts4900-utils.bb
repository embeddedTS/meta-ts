SUMMARY = "TS-4900 Utils"
DESCRIPTION = "embeddedTS utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedTS.com>"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://github.com/embeddedTS/ts4900-utils.git;branch=master \
           file://tssilomon.service"
SRCREV = "6bed161354df7967d8a8646c7b0f81a26d764204"
PV = "1.0.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools systemd

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/tssilomon.service ${D}${systemd_unitdir}/system

        sed -i -e 's#@BINDIR@#${bindir}#g' ${D}${systemd_unitdir}/system/tssilomon.service
    fi
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "tssilomon.service"
SYSTEMD_AUTO_ENABLE = "enable"
