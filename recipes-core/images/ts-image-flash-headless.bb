DESCRIPTION = "Mininmal TS headless image to fit on the XNAND"

#IMAGE_ROOTFS_SIZE = "230000"
#IMAGE_ROOTFS_EXTRA_SPACE = "19903"

DD_MBR_IMAGE ?= "mbr-flash.dd"          
DD_INITRD_IMAGE ?= "initrd-flash.dd"            
DD_IMAGE_SIZE ?= "524288"
DD_OFFSET_KERNEL ?= "1"
DD_OFFSET_INITRD ?= "4096"
DD_OFFSET_ROOTFS ?= "8192"

IMAGE_ROOTFS_SIZE = "258048"
IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_FEATURES += " package-management ssh-server-openssh tools-debug"

IMAGE_INSTALL ?= "\
    packagegroup-base \
	packagegroup-ts-basic \
	packagegroup-core-boot \
	packagegroup-base-extended \
	ts-image-support \
	"


LICENSE = "MIT"

inherit core-image image_dd

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
