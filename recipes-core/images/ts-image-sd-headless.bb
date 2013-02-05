DESCRIPTION = "Standard TS headless image for the sd cards"

IMAGE_FEATURES += " package-management ssh-server-openssh tools-debug tools-sdk debug-tweaks "

IMAGE_INSTALL ?= "\
	packagegroup-ts-basic \
	packagegroup-core-boot \
	mono \
	gpsd \
	openjdk-7-jre \
	"

LICENSE = "MIT"

inherit core-image image_dd

DD_MBR_IMAGE ?= "mbr-sd.dd"          
DD_INITRD_IMAGE ?= "initrd-sd.dd"            
DD_IMAGE_SIZE ?= "3678208"
DD_OFFSET_KERNEL ?= "16064"
DD_OFFSET_INITRD ?= "20162"
DD_OFFSET_ROOTFS ?= "24260"
DD_VFAT_DUMMY = "1"
# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
