DESCRIPTION = "Standard TS headless image for the sd cards"

IMAGE_FEATURES += "splash package-management ssh-server-openssh tools-debug tools-sdk debug-tweaks x11-base "

IMAGE_INSTALL ?= "\
	packagegroup-ts-basic \
	packagegroup-core-boot \
	mono \
	gpsd \
	openjdk-7-jre \
	packagegroup-core-gtk-directfb \
	xinput \
	"

LICENSE = "MIT"

inherit core-image image_dd

DD_MBR_IMAGE ?= "mbr-sd.dd"          
DD_INITRD_IMAGE ?= "initrd-sd.dd"            
DD_IMAGE_SIZE ?= "1900000"
DD_OFFSET_KERNEL ?= "16064"
DD_OFFSET_INITRD ?= "20162"
DD_OFFSET_ROOTFS ?= "24260"
DD_VFAT_DUMMY = "1"

IMAGE_ROOTFS_SIZE = "1800000"
IMAGE_OVERHEAD_FACTOR = "1.0"


# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
