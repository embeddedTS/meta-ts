SUMMARY = "TS-7180 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5686c7910bf44493b8e4e972cb6ada68"

# Note that libgpiod < 2.x is needed
DEPENDS = " libgpiod"

BRANCH = "master"
TAG = "1.0.0"

PV = "${TAG}"
SRC_URI = "git://github.com/embeddedTS/ts7180-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${TAG}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
