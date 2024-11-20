# Based on core-image-full-cmdline but additional packages for eTS hardware support
# and ease of use for getting started.

include recipes-extended/images/core-image-full-cmdline.bb
include recipes-extended/images/embeddedts-image-includes.inc

COMPATIBLE_MACHINE = "(tsimx6|tsimx6ul)"
