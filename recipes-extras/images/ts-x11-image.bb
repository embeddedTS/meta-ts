SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "package-management x11-base ssh-server-openssh tools-sdk tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline packagegroup-core-x11 packagegroup-core-eclipse-debug packagegroup-core-tools-debug packagegroup-qt5-toolchain-target linux-firmware matchbox-wm matchbox-desktop matchbox-terminal matchbox-keyboard bash-completion fbset imagemagick vim picocom iperf rfkill iotop libmodbus fbgrab gtkperf eglinfo-x11 hostapd libsocketcan canutils qtwebkit cinematicexperience cairo pango fontconfig freetype xinput-calibrator wvdial ppp boost libusb1 python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading util-linux-mkfs e2fsprogs tcpdump ts4900-utils sqlite3 usbutils iw wpa-supplicant nfs-utils alsa-utils-alsamixer wireless-tools i2c-tools qtdeclarative-qmlplugins qtquickcontrols-qmlplugins qtquick1 nano ntp alsa-tools alsa-utils hexedit espeak devmem2 usb-modeswitch lsof curl gst-fsl-plugin gstreamer1.0-plugins-base gstreamer1.0-plugins-bad glew gst-plugins-base chromium imx-vpu"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
