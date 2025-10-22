SUMMARY = "TS-7553-V2 system utilities"
DESCRIPTION = "Utilities for interfacing with the TS-7553-V2 hardware"
HOMEPAGE = "https://github.com/embeddedTS/ts7553v2-utils"
BUGTRACKER = "https://github.com/embeddedTS/ts7553v2-utils/issues"
SECTION = "bsp"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8bb882cd636fc6b4a8a29d9a13363df"

# Note that libgpiod < 2.x is needed
DEPENDS = "cairo libgpiod"

SRC_URI = "git://github.com/embeddedTS/ts7553v2-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"
S = "${UNPACKDIR}/git"

# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'libgpiod-tools tssilomon-start', '', d)}"

BRANCH = "master"

inherit autotools pkgconfig
