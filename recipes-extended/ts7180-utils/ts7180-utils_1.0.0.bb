SUMMARY = "TS-7180 system utilities"
DESCRIPTION = "Utilities for interfacing with the TS-7180 hardware and FPGA"
HOMEPAGE = "https://github.com/embeddedTS/ts7180-utils"
BUGTRACKER = "https://github.com/embeddedTS/ts7180-utils/issues"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5686c7910bf44493b8e4e972cb6ada68"

# Note that libgpiod < 2.x is needed
DEPENDS = "libgpiod"

SRC_URI = "git://github.com/embeddedTS/ts7180-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"
S = "${UNPACKDIR}/git"

# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'libgpiod-tools tssilomon-start', '', d)}"

BRANCH = "master"

inherit autotools pkgconfig
