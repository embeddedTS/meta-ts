DESCRIPTION = "u-boot for TS-4900"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "master"
SRCREV = "8a9422d5ddf45e40d6753f2b2ed28023b8ba5542"
SRC_URI = "https://github.com/embeddedarm/u-boot.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "tsimx6"
