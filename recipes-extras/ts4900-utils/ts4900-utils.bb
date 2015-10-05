SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master"

SRCREV = "5a2b2108c3602739077e36a15506b81143dcccd4"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
