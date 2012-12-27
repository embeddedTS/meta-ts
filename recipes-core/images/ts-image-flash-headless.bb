DESCRIPTION = "Mininmal TS headless image to fit on the XNAND"

IMAGE_ROOTFS_SIZE = "250000"

IMAGE_FEATURES += " package-management ssh-server-openssh tools-debug"

IMAGE_INSTALL ?= "\
	packagegroup-ts-basic \
	packagegroup-core-boot \
	"


LICENSE = "MIT"

inherit core-image

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
