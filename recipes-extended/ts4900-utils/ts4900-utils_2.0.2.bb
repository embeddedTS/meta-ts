SUMMARY = "TS-4900 system utilities"
DESCRIPTION = "Utilities for interfacing with the TS-4900 hardware and FPGA"
HOMEPAGE = "https://github.com/embeddedTS/ts4900-utils"
BUGTRACKER = "https://github.com/embeddedTS/ts4900-utils/issues"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=baff28f1c94c68bc8782a20fdaf9b236"

# Note that libgpiod < 2.x is needed
DEPENDS = "libgpiod"

SRC_URI = "git://github.com/embeddedTS/ts4900-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"
S = "${UNPACKDIR}/git"

# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'libgpiod-tools tssilomon-start', '', d)}"

BRANCH = "master"

inherit autotools pkgconfig
