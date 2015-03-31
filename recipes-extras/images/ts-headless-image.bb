SUMMARY = "TS Headless Image"

IMAGE_FEATURES += "package-management ssh-server-openssh tools-sdk tools-debug tools-profile eclipse-debug"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline  packagegroup-core-eclipse-debug packagegroup-core-tools-debug linux-firmware bash-completion vim picocom iperf rfkill iotop libmodbus hostapd libsocketcan canutils wvdial ppp boost libusb1 python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading util-linux-mkfs e2fsprogs tcpdump ts4900-utils sqlite3 usbutils iw wpa-supplicant nfs-utils alsa-utils-alsamixer wireless-tools i2c-tools nano ntp alsa-tools alsa-utils hexedit espeak devmem2 usb-modeswitch lsof curl"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
