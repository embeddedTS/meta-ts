SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;beginline=1;endline=20;md5=026b7328d0846296910939c71185e59c"

inherit module
SRCREV = "9951258aad2ca8e0a951d71a90219b02f665f488"
SRC_URI = "git://github.com/embeddedTS/qcacld-2.0.git;branch=${SRCBRANCH}"
SRCBRANCH = "caf-wlan/CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"