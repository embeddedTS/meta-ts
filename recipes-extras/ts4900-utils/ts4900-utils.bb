SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master"

SRCREV = "673058c94b1f72685a884d5a6dec0cbb49afa8bd"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
