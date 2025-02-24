MACHINEOVERRIDES =. "mx93:tsimx93"

require conf/machine/include/imx-base.inc
require conf/machine/include/arm/armv8-2a/tune-cortexa55.inc

MACHINE_FEATURES += "pci bluetooth"
MACHINE_FEATURES:append:use-nxp-bsp = " optee jailhouse"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-prototype-imx93"
IMX_DEFAULT_KERNEL = "linux-prototype-imx93"
KERNEL_DEVICETREE = " \
    freescale/${KERNEL_DEVICETREE_BASENAME}.dtb \
"

PREFERRED_PROVIDER_u-boot = "u-boot-ts"
IMX_DEFAULT_KERNEL = "linux-prototype-imx93"
IMX_DEFAULT_BOOTLOADER = "u-boot-ts"

PREFERRED_PROVIDER_u-boot = "u-boot-ts"
PREFERRED_PROVIDER_u-boot-mfgtool = "u-boot-ts"
PREFERRED_PROVIDER_u-boot-tools = "u-boot-ts"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-ts"

LOADADDR = ""
UBOOT_SUFFIX = "bin"
UBOOT_MAKE_TARGET = ""

SPL_BINARY = "spl/u-boot-spl.bin"

UBOOT_CONFIG ??= "sd"
UBOOT_CONFIG[sd]   = "${UBOOT_CONFIG_BASENAME}_defconfig,sdcard"
UBOOT_CONFIG[ecc]  = "${UBOOT_CONFIG_BASENAME}_inline_ecc_defconfig"
UBOOT_CONFIG[ld]   = "${UBOOT_CONFIG_BASENAME}_ld_defconfig"

# Set ATF platform name
ATF_PLATFORM = "imx93"

IMXBOOT_TARGETS = "flash_singleboot"

IMX_BOOT_SOC_TARGET = "iMX9"
IMX_BOOT_SEEK = "32"

# We have to disable SERIAL_CONSOLE due to auto-serial-console
SERIAL_CONSOLES = "115200;ttyLP0"

IMX_DEFAULT_BSP = "nxp"