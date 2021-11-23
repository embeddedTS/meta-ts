SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=08eb81eeaccfa92905e7444a5a37bcf2"

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master \
           file://tssilomon.service"
SRCREV = "f6a0a778a81c31b94bd5118a04863dc4925a8e2a"
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
