SUMMARY = "TS Headless Image"

IMAGE_FEATURES += "package-management dev-pkgs ssh-server-openssh tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-core-boot \
	packagegroup-core-eclipse-debug \
	packagegroup-core-full-cmdline \
	packagegroup-core-tools-debug \
	packagegroup-machine-base \
	alsa-utils-alsamixer \
	bash-completion \
	boost \
	canutils \
	curl \
	devmem2 \
	e2fsprogs \
	espeak \
	hexedit \
	hostapd \
	i2c-tools \
	imagemagick \
	iotop \
	iperf \
	iw \
	ldd \
	libmodbus \
	libsocketcan \
	libusb1 \
	lighttpd-module-cgi \
	linux-firmware \
	lsof \
	modemmanager \
	nano \
	nfs-utils \
	picocom \
	ppp \
	python-core \
	python-ctypes \
	python-dev \
	python-mmap \
	python-modules \
	python-shell \
	python-threading \
	rsync \
	sqlite3 \
	tcpdump \
	usb-modeswitch \
	usbutils \
	util-linux-mkfs \
	wireless-tools \
	wpa-supplicant \
	wvdial \
"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
