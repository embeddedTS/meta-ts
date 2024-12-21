# This file can and should be included in image recipes in order to
# properly include any additional or necessary applications for hardware
# support of individual machines.

# Below are a handful of IMAGE_INSTALL:append parameters, grouped by their function
# rather than by machine type or a single stanza for each machine.
# In theory, each of these could be an RDEPENDS/RRECOMMENDS of a machine,
# however, each of the groups below are not vital to the operation of a platform
# and the machine can still run without them included. Using IMAGE_INSTALL in
# this way makes it easier for custom images to remove if they are unwanted.
# In contrast to the MACHINE[_ESSENTIAL]_EXTRA_R* setting that would need to be
# modified in the conf file or a custom machine conf created which is not ideal.


# Utilities support for platforms
IMAGE_INSTALL:append:tsimx6 = " ts4900-utils"
IMAGE_INSTALL:append:ts4100 = " ts4100-utils zpu-elf-gcc-armhf"
IMAGE_INSTALL:append:ts7180 = " ts7180-utils"
IMAGE_INSTALL:append:ts7100 = " ts7100-utils"
IMAGE_INSTALL:append:ts7250v3 = " ts7100-utils"
IMAGE_INSTALL:append:ts7553v2 = " ts7553v2-utils"


# Firmware needed by different machines
# Note that, if the wilc3000-external-module is in the image, it separately
# RDEPENDS on the wilc3000 firmware and does not need to be added here
IMAGE_INSTALL:append:ts4100 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts4900 = " linux-firmware-ath10k linux-firmware-wl12xx"
IMAGE_INSTALL:append:ts7100 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7180 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7250v3 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7970 = " linux-firmware-ath10k linux-firmware-wl12xx"
IMAGE_INSTALL:append:ts7990 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7553v2 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7800v2 = " wilc3000-external-module"
IMAGE_INSTALL:append:ts7840 = " linux-firmware-ath10k"


# Allow root as a login account with no password
# Use openssh since dropbear default has some quirks with first boot
EXTRA_IMAGE_FEATURES += "empty-root-password ssh-server-openssh"
