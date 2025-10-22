SUMMARY = "Idleinject utility to inject idle cycles"
DESCRIPTION = "Used to effectively "pause" all usespace applications when \
               the CPU is at a dangerous temperature extreme. This is \
               written and intended for use on CPUs which do not have proper \
               thermal throttling in-kernel at this time."
HOMEPAGE = "https://github.com/embeddedts/idleinject"
BUGTRACKER = "https://github.com/embeddedTS/idleinject/issues"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

SRC_URI = "git://github.com/embeddedTS/idleinject.git;protocol=https;branch=${BRANCH} \
           file://idleinject.service \
           file://idleinject"
SRCREV = "v${PV}"
S = "${UNPACKDIR}/git"
FILES:${PN} += "${systemd_unitdir}/system/idleinject.service \
                ${sysconfdir}/init.d/idleinject"

BRANCH = "main"

inherit meson pkgconfig  systemd update-rc.d

# Install the unit or init script alongside the meson-installed binary
do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${UNPACKDIR}/idleinject.service ${D}${systemd_unitdir}/system/idleinject.service
        # Replace placeholder with the path the service should call
        sed -i -e 's#@BINDIR@#${base_bindir}#g' ${D}${systemd_unitdir}/system/idleinject.service
    elif ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${UNPACKDIR}/idleinject ${D}${sysconfdir}/init.d/idleinject
        sed -i -e 's#@BINDIR@#${base_bindir}#g' ${D}${sysconfdir}/init.d/idleinject
    else
        bbfatal "Using neither systemd nor sysvinit for init system! idleinject startup script will not be installed but is required for safe operation! Consider using systemd or sysvinit for the init system."
    fi
}

INITSCRIPT_NAME = "idleinject"
INITSCRIPT_PARAMS = "defaults 99"

SYSTEMD_SERVICE:${PN} = "idleinject.service"
SYSTEMD_AUTO_ENABLE = "enable"
