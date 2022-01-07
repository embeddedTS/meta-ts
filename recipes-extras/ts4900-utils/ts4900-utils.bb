SUMMARY = "TS-4900 Utils"
DESCRIPTION = "embeddedTS utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedTS.com>"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

SRC_URI = "git://github.com/embeddedTS/ts4900-utils.git;branch=master"

SRCREV = "d30c1c15993d946197116562426178f225b0fba4"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
