DESCRIPTION = "u-boot for TS-4900, TS-7970, TS-7990"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2015.04_3.14.52_1.1.0_ga"
SRCREV = "ef0f64b4308b8cb4080364e4d595ae841d679c80"
SRC_URI = "https://github.com/embeddedTS/u-boot-imx.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "tsimx6"
