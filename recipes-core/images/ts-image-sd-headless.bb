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

inherit core-image

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
