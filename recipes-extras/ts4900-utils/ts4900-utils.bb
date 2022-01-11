SUMMARY = "TS-4900 Utils"
DESCRIPTION = "embeddedTS utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedTS.com>"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "base"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=baff28f1c94c68bc8782a20fdaf9b236"

SRC_URI = "git://github.com/embeddedTS/ts4900-utils.git;branch=master \
           file://tssilomon.service"
SRCREV = "0d77ae39d82fe8846fb8e4c06c31bbc69ecba77b"
PV = "1.0.0+git${SRCPV}"
S = "${WORKDIR}/git"

RDEPENDS_ts4900-utils = "bash"

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
