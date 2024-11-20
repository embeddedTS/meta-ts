# Based on core-image-weston but additional packages for eTS hardware support
# and ease of use for getting started.

include recipes-graphics/images/core-image-weston.bb
include recipes-extended/images/embeddedts-image-includes.inc

COMPATIBLE_MACHINE = "(tsimx6|tsimx6ul)"
