SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "package-management x11-base ssh-server-openssh tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-core-boot \
	packagegroup-core-buildessential \
	packagegroup-core-eclipse-debug \
	packagegroup-core-full-cmdline \
	packagegroup-core-tools-debug \
	packagegroup-core-x11 \
	packagegroup-machine-base \
	packagegroup-qt5-toolchain-target \
	alsa-utils-alsamixer \
	bash-completion \
	boost \
	canutils \
	cinematicexperience \
	curl \
	devmem2 \
	e2fsprogs \
	espeak \
	fbgrab \
	fbset \
	fontconfig \
	freetype \
	gtkperf \
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
	matchbox-desktop \
	matchbox-keyboard \
	matchbox-terminal \
	matchbox-wm \
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
	qtdeclarative-qmlplugins \
	qtmultimedia \
	qtquick1 \
	qtquickcontrols-qmlplugins \
	qtwebkit \
	rsync \
	sqlite3 \
	tcpdump \
	usb-modeswitch \
	usbutils \
	util-linux-mkfs \
	wireless-tools \
	wpa-supplicant \
	wvdial \
	xcursor-transparent-theme \
	xinput-calibrator \
	"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
