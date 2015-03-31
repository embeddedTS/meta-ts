# Common settings for ts4900 boards

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa9.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-technologic"
PREFERRED_VERSION_linux-technologic ?= "3.10.53"


SERIAL_CONSOLE = "115200 ttymxc0"

KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "imx6dl-ts4900.dtb imx6q-ts4900.dtb imx6q-ts4900-2.dtb imx6dl-ts4900-2.dtb imx6q-ts4900-9.dtb imx6dl-ts4900-9.dtb imx6q-ts4900-a.dtb imx6dl-ts4900-a.dtb imx6q-ts4900-14.dtb imx6dl-ts4900-14.dtb imx6q-ts7970.dtb imx6dl-ts7970.dtb"

IMAGE_BOOTLOADER = ""
IMAGE_INSTALL += " ts4900-fpga kernel-devicetree linux-firmware"

MACHINE_EXTRA_RRECOMMENDS += "linux-firmware-wl12xx"
MACHINE_FEATURES += " pci wifi bluetooth touchscreen"

# Since I'm including new gpu drivers, override freescale's older version requirement.
PREFERRED_VERSION_xserver-xorg_mx6 = "2:1.15.1"
PREFERRED_VERSION_directfb_mx6 = "1.7.4"
PREFERRED_VERSION_directfb-examples_mx6 = "1.7.0"


# New gl plugin required for new gpu to remove dependency on old vivante driver
PREFERRED_VERSION_gst-fsl-plugin = "4.0.2"
PREFERRED_VERSION_gst1.0-fsl-plugin = "4.0.2"
PREFERRED_VERSION_libfslvpuwrap = "1.0.57"

# mx6 GPU libraries
PREFERRED_PROVIDER_virtual/egl_mx6 = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6sl = "mesa"
PREFERRED_PROVIDER_virtual/libgles2_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6sl = "mesa"
PREFERRED_PROVIDER_virtual/libgl_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6sl = "mesa"
PREFERRED_PROVIDER_virtual/libg2d_mx6 = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgal-x11 = "imx-gpu-viv"


PREFERRED_PROVIDER_virtual/fftw = "fftw"
