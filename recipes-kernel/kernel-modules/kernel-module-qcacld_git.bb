SUMMARY = "QCACLD driver for QCA9377-based BD-SDMAC module"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${S}/CORE/HDD/src/wlan_hdd_main.c;beginline=1;endline=20;md5=026b7328d0846296910939c71185e59c"

inherit module
SRCREV = "1088ab67265d1b8ea11767b73210b5bdf9c7f84f"
SRC_URI = "git://github.com/embeddedarm/qcacld-2.0.git;branch=${SRCBRANCH}"
SRCBRANCH = "caf-wlan/CNSS.LEA.NRT_3.1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"