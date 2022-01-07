# Adapted from linux-imx.inc, copyright (C) 2012, 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for TS-4900"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc

# Put a local version until we have a true SRCREV to point to
LOCALVERSION ?= "+yocto"
SCMVERSION ?= "y"

SRCBRANCH ??= "master"

# Allow override of TECHNOLOGIC_GITHUB_MIRROR to make use of
# local repository easier
TECHNOLOGIC_GITHUB_MIRROR ?= "git://github.com/embeddedTS/linux-3.10.17-imx6.git"

# SRC_URI for ts kernel
SRC_URI = "${TECHNOLOGIC_GITHUB_MIRROR};branch=${SRCBRANCH} \
           file://defconfig \
"
