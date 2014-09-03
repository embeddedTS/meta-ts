SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "package-management x11-base dev-pkgs"

IMAGE_INSTALL += "packagegroup-core-boot packagegroup-core-x11 autoconf automake binutils cpp cpp-symlinks gcc gcc-symlinks g++ g++-symlinks gettext make libstdc++ libstdc++-dev file coreutils packagegroup-fsl-gstreamer-full xterm twm matchbox-wm matchbox-desktop matchbox-terminal matchbox-keyboard i2c-tools nano bash-completion devmem2 fbset imagemagick vim usb-modeswitch picocom glmark2 iperf iw rfkill iotop libmodbus gtk+ gtkhtml2 fbgrab gtkperf fsl-gpu-sdk eglinfo-x11 gst-plugins-base gst-fsl-plugin gstreamer1.0-plugins-imx gst-plugins-gl hostap-daemon libsocketcan canutils alsa-utils alsa-state v4l-utils qtwebkit qtbase qtbase-fonts qtbase-plugins qtbase-examples cinematicexperience qtmultimedia qtquick1 gstreamer cairo pango fontconfig freetype pulseaudio xinput-calibrator gst-plugins-base-meta gst-plugins-good-meta gst-plugins-bad-meta gst-plugins-gl wvdial ppp boost libusb1 openssh wpa-supplicant iproute2 wireless-tools avahi nfs-utils ruby python-modules python-core python-ctypes python-dev python-mmap python-shell python-threading lsof usbutils util-linux-mkfs e2fsprogs tcpdump strace ltrace ts4900-utils"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
