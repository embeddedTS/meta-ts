SUMMARY = "TS-7670 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8bb882cd636fc6b4a8a29d9a13363df"

BRANCH = "master"

SRC_URI = "git://github.com/embeddedTS/ts7670-utils-linux4.x.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
