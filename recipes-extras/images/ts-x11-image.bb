SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "x11-base debug-tweaks package-management ssh-server-openssh tools-debug tools-profile nfs-client qtcreator-debug tools-sdk"

IMAGE_INSTALL += "packagegroup-core-boot \
	packagegroup-core-buildessential \
	packagegroup-core-full-cmdline \
	packagegroup-machine-base \
	packagegroup-qt5-toolchain-target \
	alsa-utils-alsactl \
	alsa-utils-alsamixer \
	alsa-utils-amixer \
	alsa-utils-aplay \
	alsa-utils-speakertest \
	bash-completion \
	boost \
	canutils \
	cinematicexperience \
	clutter-1.0-examples \
	curl \
	devmem2 \
	e2fsprogs \
	eglinfo-x11 \
	espeak \
	fbgrab \
	fbset \
	fontconfig-utils \
	freetype \
	git \
	gst1.0-fsl-plugin \
	gtk+3-demo \
	hexedit \
	hostapd \
	i2c-tools \
	imagemagick \
	iotop \
	iperf \
	iw \
	ldd \
	liberation-fonts \
	libmodbus \
	libsocketcan \
	libusb1 \
	lighttpd-module-cgi \
	linux-firmware \
	lsof \
	matchbox-keyboard \
	matchbox-terminal \
	matchbox-wm \
	modemmanager \
	nano \
	nfs-utils \
	nodejs \
	openssh-sftp \
	openssh-sftp-server \
	picocom \
	ppp \
	python-core \
	python-ctypes \
	python-dev \
	python-mmap \
	python-modules \
	python-shell \
	python-threading \
	qt5-opengles2-test \
	qtbase \
	qtbase-plugins \
	qtbase-tools \
	qtcharts \
	qtdeclarative-qmlplugins \
	qtmultimedia \
	qtquick1 \
	qtquickcontrols-qmlplugins \
	qtquickcontrols2 \
	qtscript \
	qtsensors \
	qtserialbus \
	qtserialport \
	qtvirtualkeyboard \
	qtwebkit \
	rsync \
	sqlite3 \
	tcpdump \
	ttf-bitstream-vera \
	ttf-dejavu-common \
	ttf-dejavu-sans \
	ttf-dejavu-sans-mono \
	usb-modeswitch \
	usbutils \
	util-linux-mkfs \
	wireless-tools \
	wpa-supplicant \
	xcursor-transparent-theme \
	xinput-calibrator \
	xterm "

EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
