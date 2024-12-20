MACHINEOVERRIDES =. "mx6:mx6q:mx6dl:tsimx6:"

include conf/machine/include/arm/armv7a/tune-cortexa9.inc

# Disable building u-boot
IMAGE_BOOTLOADER = ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-lts-ts"

KERNEL_IMAGETYPE = "zImage"
KERNEL_IMAGETYPES += "uImage"
KERNEL_EXTRA_ARGS += "LOADADDR=0x10008000"

SERIAL_CONSOLES = "115200;ttymxc0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "kernel-image kernel-modules kernel-devicetree"

MACHINE_FEATURES += "alsa bluetooth ext2 pci rtc screen serial touchscreen usbgadget usbhost vfat wifi"

PACKAGECONFIG:append:pn-mesa = " gallium etnaviv"

IMAGE_FSTYPES = "tar.xz"

# Prefer an older 1.x version of libgpiod where possible since the current utilities
# sources are written for that and it is currently the most widely available across
# multiple distributions.
PREFERRED_VERSION_libgpiod = "1.%"

# Prefer an older 2.9 release of wpa_supplicant. There is an issue currently with
# the ath10k_sdio driver/support for our Silex part that breaks WPA-PSK in
# wpa_supplicatn 2.10+
PREFERRED_VERSION_wpa-supplicant = "2.9"
