SUMMARY = "TS-7180 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5686c7910bf44493b8e4e972cb6ada68"

# Note that libgpiod < 2.x is needed
DEPENDS = " libgpiod"
# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'tssilomon-start libgpiod-tools', '', d)}"


BRANCH = "master"

SRC_URI = "git://github.com/embeddedTS/ts7180-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

inherit autotools pkgconfig
