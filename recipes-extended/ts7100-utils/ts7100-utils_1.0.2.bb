SUMMARY = "TS-7100 system utilities, compatible with TS-7250-V3"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8bb882cd636fc6b4a8a29d9a13363df"

# Note that libgpiod < 2.x is needed
DEPENDS = " libgpiod"
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'tssilomon-start', '', d)}"

BRANCH = "master"

SRC_URI = "git://github.com/embeddedTS/ts7100-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
