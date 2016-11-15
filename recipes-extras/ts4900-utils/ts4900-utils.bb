SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master"

SRCREV = "deb725a84a055e3ce37648b41ae0a5c258591e8d"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
