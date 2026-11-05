SUMMARY = "Start script for idleinject for systemd or sysvinit"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

SRC_URI = "file://idleinject.service \
	   file://idleinject"

inherit systemd update-rc.d

do_install() {
    if "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/idleinject.service ${D}${systemd_unitdir}/system
        sed -i -e 's#@BINDIR@#${bindir}#g' ${D}${systemd_unitdir}/system/idleinject.service
    elif ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0744 ${WORKDIR}/idleinject ${D}${sysconfdir}/init.d/idleinject
        sed -i -e 's#@BINDIR@#${bindir}#g' ${D}${sysconfdir}/init.d/idleinject
    else
	bbfatal "Using neither systemd nor sysvinit for init system! idleinject startup script will not be installed but is required for safe operation! Consider using systemd or sysvinit for the init system."
    fi
}

FILES:${PN} += "/"

# These should do nothing if sysvinit is not defined as a DISTRO_FEATURE
INITSCRIPT_NAME = "idleinject"
INITSCRIPT_PARAMS = "defaults 99"

# This should do nothing if systemd is not defined as a DISTRO_FEATURE
SYSTEMD_SERVICE:${PN} = "idleinject.service"
