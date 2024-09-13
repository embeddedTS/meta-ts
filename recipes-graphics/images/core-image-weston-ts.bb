# Based on core-image-weston but additional packages for eTS hardware support
# and ease of use for getting started.

include recipes-graphics/images/core-image-weston.bb

COMPATIBLE_MACHINE = "tsimx6"

# In theory this could be a MACHINE_EXTRA_RDEPENDS of a machine, however,
# the utilities packages are not vital to the operation of a platform and
# an end user may wish to not include them.
#
# This is not specified in the machine conf files with MACHINE_EXTRA_RRECOMMENDS
# (since it is used to indicate that it would be nice to have this recipe, but
# its not necessary), because that variable is not honored for all image classes.
# Which is silly.
IMAGE_INSTALL:append:tsimx6 = " ts4900-utils"

# The TS-4900 uses an FPGA that must be reloaded on every boot, include that
# recipe only for that machine
IMAGE_INSTALL:append:ts4900 = " ts4900-fpga"

# Allow root as a login account with no password
# Use openssh since dropbear default has some quirks with first boot
EXTRA_IMAGE_FEATURES += "empty-root-password ssh-server-openssh"
