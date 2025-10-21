SUMMARY = "TS-4900 FPGA Bitstream"
HOMEPAGE = "http://www.embeddedTS.com/"

COMPATIBLE_MACHINE = "tsimx6"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e0398ea6391ea94e81667cdb86a0aaf3"

SRC_URI = "https://files.embeddedts.com/ts-socket-macrocontrollers/ts-4900-linux/fpga/ts4900-fpga-${PV}.bin \
           file://LICENSE.txt"
SRC_URI[sha256sum] = "f15edd6813ee5e93e7f380d85df2dc31e764ebca465093fb9006d56ee15b476b"

S = "${UNPACKDIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}/boot
    install -m 0644 "${S}/ts4900-fpga-${PV}.bin" ${D}/boot/ts4900-fpga.bin
}

FILES:${PN} += "/boot/ts4900-fpga.bin"
