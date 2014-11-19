SUMMARY = "TS-4900 FPGA"
DESCRIPTION = "Ice40 FPGA Bitstream"
AUTHOR = "Mark Featherston <mark@embeddedarm.com>"
HOMEPAGE = "http://www.embeddedarm.com/"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = ""

FILESEXTRAPATHS_prepend := "${THISDIR}/"

SRC_URI = "file://ts4900-fpga.bin file://ts7970-fpga.bin"

S = "${WORKDIR}"

FILES_${PN} =  "/boot/*"

do_install() {
    install -d ${D}/boot/
    install -m 0755 ts4900-fpga.bin ${D}/boot/
    install -m 0755 ts7970-fpga.bin ${D}/boot/
}
