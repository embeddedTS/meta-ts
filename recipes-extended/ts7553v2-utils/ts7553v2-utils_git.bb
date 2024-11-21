SUMMARY = "TS-7553-V2 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8bb882cd636fc6b4a8a29d9a13363df"

# Note that libgpiod < 2.x is needed
DEPENDS = " libgpiod cairo"
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'tssilomon-start', '', d)}"

BRANCH = "master"
TAG = "2.0.1"

PV = "${TAG}"
SRC_URI = "git://github.com/embeddedTS/ts7553v2-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${TAG}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
