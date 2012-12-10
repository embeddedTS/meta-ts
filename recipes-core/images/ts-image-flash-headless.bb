DESCRIPTION = "Mininmal TS headless image to fit on the XNAND"

IMAGE_FEATURES += "splash packge-management ssh-server-openssh"

IMAGE_INSTALL ?= "\
	packagegroup-core-basic \
	packagegroup-core-boot \
	vim \
	perl \
	python \
	tcl \
	php \
	apache2 \
	mysql5 \
	vsftpd \
	openjdk-7-jre \
	mono \
	gpsd \
	gpsd-conf \
	gps-utils \
	libgps \
	libgpsd \
	"

LICENSE = "MIT"

inherit core-image

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
