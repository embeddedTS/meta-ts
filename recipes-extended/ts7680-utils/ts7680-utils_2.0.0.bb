SUMMARY = "TS-7680 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0deb455fa485cd99c8fd0344ea4b23b4"

DEPENDS = " libgpiod"
# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'tssilomon-start libgpiod-tools', '', d)}"

BRANCH = "master"

SRC_URI = "git://github.com/embeddedTS/ts7680-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
