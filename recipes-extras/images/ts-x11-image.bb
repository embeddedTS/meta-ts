SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "package-management x11-base ssh-server-openssh tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline packagegroup-core-x11 packagegroup-core-eclipse-debug packagegroup-core-tools-debug packagegroup-qt5-toolchain-target linux-firmware matchbox-wm matchbox-desktop matchbox-terminal matchbox-keyboard bash-completion fbset imagemagick picocom iperf iotop libmodbus fbgrab gtkperf eglinfo-x11 hostapd libsocketcan canutils cinematicexperience fontconfig freetype xinput-calibrator wvdial ppp boost libusb1 python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading util-linux-mkfs e2fsprogs tcpdump sqlite3 usbutils iw wpa-supplicant nfs-utils alsa-utils-alsamixer wireless-tools i2c-tools nano hexedit espeak devmem2 usb-modeswitch lsof curl chromium gst1.0-fsl-plugin packagegroup-core-buildessential ldd xcursor-transparent-theme rsync lighttpd-module-cgi nodejs nodejs-npm git vim"
 
EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
