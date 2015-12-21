SUMMARY = "TS Headless Image"

IMAGE_FEATURES += "package-management dev-pkgs ssh-server-openssh tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline packagegroup-core-eclipse-debug packagegroup-core-tools-debug linux-firmware bash-completion imagemagick picocom iperf iotop libmodbus hostapd libsocketcan canutils wvdial ppp boost libusb1 python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading util-linux-mkfs e2fsprogs tcpdump sqlite3 usbutils iw wpa-supplicant nfs-utils alsa-utils-alsamixer wireless-tools i2c-tools nano hexedit espeak devmem2 usb-modeswitch lsof curl ldd rsync lighttpd-module-cgi"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
