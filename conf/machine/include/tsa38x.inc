MACHINEOVERRIDES =. "armada38x:armada385:tsa38x:"

include conf/machine/include/arm/armv7a/tune-cortexa9.inc

# Disable building u-boot
IMAGE_BOOTLOADER = ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-lts-ts"

KERNEL_IMAGETYPE = "zImage"

SERIAL_CONSOLES = "115200;ttyS0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "idleinject kernel-image kernel-modules kernel-devicetree"

MACHINE_FEATURES += "bluetooth ext2 pci rtc serial usbhost vfat wifi"

IMAGE_FSTYPES = "tar.xz"

# Prefer an older 1.x version of libgpiod where possible since the current utilities
# sources are written for that and it is currently the most widely available across
# multiple distributions.
PREFERRED_VERSION_libgpiod = "1.%"
