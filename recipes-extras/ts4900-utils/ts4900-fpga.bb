SUMMARY = "TS-4900 Utils"
DESCRIPTION = "Technologic Systems utilities, gpioctl, tshwctl, nvramctl"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

FILESEXTRAPATHS_prepend := "${THISDIR}/"

SRC_URI = "git://github.com/embeddedarm/ts4900-utils.git;branch=master"

SRCREV = "71e6baa157b62c28ebe69b3d09ddd075614a7a82"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
