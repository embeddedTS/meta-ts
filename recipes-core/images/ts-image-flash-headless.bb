DESCRIPTION = "Mininmal TS headless image to fit on the XNAND"

#IMAGE_ROOTFS_SIZE = "230000"
#IMAGE_ROOTFS_EXTRA_SPACE = "19903"
IMAGE_ROOTFS_SIZE = "258048"
IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_FEATURES += " package-management ssh-server-openssh tools-debug"

IMAGE_INSTALL ?= "\
	packagegroup-ts-basic \
	packagegroup-core-boot \
	packagegroup-base-extended \
	"


LICENSE = "MIT"

inherit core-image

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
