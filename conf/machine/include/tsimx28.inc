MACHINEOVERRIDES =. "mxs:mx28:tsimx28:"

include conf/machine/include/arm/armv5/tune-arm926ejs.inc

# Disable building u-boot
IMAGE_BOOTLOADER = ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-lts-ts"

KERNEL_IMAGETYPE = "uImage"
UBOOT_LOADADDRESS = "0x40008000"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_LOADADDRESS}"

SERIAL_CONSOLES = "115200;ttyAMA0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "kernel-image kernel-modules kernel-devicetree"

MACHINE_FEATURES += "bluetooth ext2 rtc serial usbgadget usbhost vfat wifi"

# Individual machine conf files need to specify the WKS_FILE variable for this
IMAGE_FSTYPES += "wic wic.bmap"

# Prefer an older 1.x version of libgpiod where possible since the current utilities
# sources are written for that and it is currently the most widely available across
# multiple distributions.
PREFERRED_VERSION_libgpiod = "1.%"
