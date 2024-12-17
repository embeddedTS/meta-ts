MACHINEOVERRIDES =. "mx6ul:tsimx6ul:"

include conf/machine/include/arm/armv7a/tune-cortexa7.inc

# Disable building u-boot
IMAGE_BOOTLOADER = ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-lts-ts"

KERNEL_IMAGETYPE = "zImage"

SERIAL_CONSOLES = "115200;ttymxc0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "kernel-image kernel-modules kernel-devicetree linux-firmware"

MACHINE_FEATURES += "bluetooth ext2 rtc serial usbgadget usbhost vfat wifi"

IMAGE_FSTYPES = "tar.xz"

# Prefer an older 1.x version of libgpiod where possible since the current utilities
# sources are written for that and it is currently the most widely available across
# multiple distributions.
PREFERRED_VERSION_libgpiod = "1.%"
