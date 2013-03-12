DESCRIPTION = "Fullscreen webkit example which shows http://127.0.0.1 in fullscreen"
SECTION = "graphics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "git://github.com/embeddedarm/fullscreen-webkit.git;protocol=git;tag=3c1230f12045a7b89776b970c1abb6a0cb284c34"

S = "${WORKDIR}/git"

do_compile() {
    ${CC} fullscreen-webkit.c `pkg-config webkit-1.0 --cflags --libs` -o fullscreen-webkit
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 fullscreen-webkit ${D}${bindir}
}
