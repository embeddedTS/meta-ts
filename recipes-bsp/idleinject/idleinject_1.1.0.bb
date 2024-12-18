SUMMARY = "Idleinject utility to inject idle cycles to a embeddedTS tsa38x platform"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

RDEPENDS:${PN} += "idleinject-start"

BRANCH = "main"

SRC_URI = "git://github.com/embeddedTS/idleinject.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig
