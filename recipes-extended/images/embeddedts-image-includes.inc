# This file can and should be included in image recipes in order to
# properly include any additional or necessary applications for hardware
# support of individual machines.

# Utilities support for platforms

# In theory this could be an RDEPENDS of a machine, however, the utilities
# packages are not vital to the operation of a platform and an end user may
# wish to not include them.
IMAGE_INSTALL:append:tsimx6 = " ts4900-utils"
IMAGE_INSTALL:append:ts4100 = " ts4100-utils zpu-elf-gcc-armhf"
IMAGE_INSTALL:append:ts7180 = " ts7180-utils"
IMAGE_INSTALL:append:ts7100 = " ts7100-utils"
IMAGE_INSTALL:append:ts7250v3 = " ts7100-utils"
IMAGE_INSTALL:append:ts7553v2 = " ts7553v2-utils"


# Platforms with the WILC3000 module that need the external driver and firmware
IMAGE_INSTALL:append:ts4100 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7100 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7180 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7250v3 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7990 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7553v2 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7800v2 = " wilc3000-external-module"


# Allow root as a login account with no password
# Use openssh since dropbear default has some quirks with first boot
EXTRA_IMAGE_FEATURES += "empty-root-password ssh-server-openssh"
