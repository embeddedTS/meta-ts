SUMMARY = "TS Headless Image"

IMAGE_FEATURES += "package-management dev-pkgs"

IMAGE_INSTALL += "packagegroup-core-boot autoconf automake binutils cpp cpp-symlinks gcc gcc-symlinks g++ g++-symlinks gettext make libstdc++ libstdc++-dev file coreutils i2c-tools nano bash-completion devmem2 imagemagick vim usb-modeswitch picocom iperf iw rfkill iotop libmodbus hostap-daemon libsocketcan canutils alsa-utils alsa-state wvdial ppp boost libusb1 openssh wpa-supplicant iproute2 wireless-tools avahi nfs-utils ruby python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading lsof usbutils util-linux-mkfs e2fsprogs tcpdump ts4900-utils"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
