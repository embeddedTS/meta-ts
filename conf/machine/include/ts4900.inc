# Common settings for ts4900 boards

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa9.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-technologic"
PREFERRED_VERSION_linux-technologic ?= "3.10.17"

SERIAL_CONSOLE = "115200 ttymxc0"

MACHINE_FEATURES += "pci touchscreen"

KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "imx6dl-ts4900.dtb imx6q-ts4900.dtb imx6q-ts4900-2.dtb imx6dl-ts4900-2.dtb imx6q-ts4900-9.dtb imx6dl-ts4900-9.dtb imx6q-ts4900-a.dtb imx6dl-ts4900-a.dtb imx6q-ts7970.dtb imx6dl-ts7970.dtb"

IMAGE_BOOTLOADER = ""
IMAGE_INSTALL += " ts4900-fpga kernel-devicetree"
