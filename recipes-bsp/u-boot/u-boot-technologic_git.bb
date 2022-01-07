DESCRIPTION = "u-boot for TS-4900, TS-7970, TS-7990"
require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-mender.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "v2014.10-mender"
SRCREV = "4b41d33365c532853dac9f165027caf01b66f953"
SRC_URI = "git://github.com/embeddedTS/u-boot.git;branch=${SRCBRANCH}"

PROVIDES += "u-boot"
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(tsimx6)"
PV = "v2014.10-mender+git${SRCPV}"

BOOTENV_SIZE = "0x20000"

S = "${WORKDIR}/git"
