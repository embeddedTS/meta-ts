# Based on core-image-full-cmdline but additional packages for eTS hardware support
# and ease of use for getting started.

include recipes-extended/images/core-image-full-cmdline.bb

COMPATIBLE_MACHINE = "(tsimx6|tsimx6ul)"

# Machine specific requirement dependencies

# The TS-4900 uses an FPGA that must be reloaded on every boot, include that
# recipe only for that machine
IMAGE_INSTALL:append:ts4900 = " ts4900-fpga"


# Utilities support for platforms

# In theory this could be an RDEPENDS of a machine, however, the utilities
# packages are not vital to the operation of a platform and an end user may
# wish to not include them.
IMAGE_INSTALL:append:tsimx6 = " ts4900-utils"
IMAGE_INSTALL:append:ts7553v2 = " ts7553v2-utils"
IMAGE_INSTALL:append:ts7180 = " ts7180-utils"

# Platforms with the WILC3000 module that need the external driver and firmware
IMAGE_INSTALL:append:ts7990 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7553v2 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7180 = " wilc3000-external-module"

# Allow root as a login account with no password
# Use openssh since dropbear default has some quirks with first boot
EXTRA_IMAGE_FEATURES += "empty-root-password ssh-server-openssh"
