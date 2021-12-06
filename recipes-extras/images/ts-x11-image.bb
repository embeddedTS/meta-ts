SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "x11-base debug-tweaks package-management ssh-server-openssh tools-debug nfs-client qtcreator-debug tools-sdk"

IMAGE_INSTALL_append = " \
	packagegroup-core-boot \
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
	espeak \
	fbgrab \
	fbset \
	fontconfig-utils \
	freetype \
	git \
	gstreamer1.0 \
	gstreamer1.0-meta-base \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-good \
	gtk+3-demo \
	hexedit \
	hostapd \
	i2c-tools \
	imagemagick \
	iotop \
	iperf2 \
	iperf3 \
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
	mesa-demos \
	modemmanager \
	nano \
	nfs-utils \
	nodejs \
	openssh-sftp \
	openssh-sftp-server \
	picocom \
	ppp \
	python3 \
	qt5-opengles2-test \
	qtbase \
	qtbase-plugins \
	qtbase-tools \
	qtcharts \
	qtmultimedia \
	qtmultimedia-plugins \
	qtmultimedia-qmlplugins \
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
	tzdata \
	usb-modeswitch \
	usbutils \
	util-linux-mkfs \
	wpa-supplicant \
	xcursor-transparent-theme \
	xinput-calibrator \
	xterm "

EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
