SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "splash package-management x11-base dev-pkgs doc-pkgs ssh-server-openssh tools-debug tools-sdk tools-testapps"

LICENSE = "MIT"

DISTRO_FEATURES += "bluetooth bluetooth nfs keyboard ipv6 ppp wifi usbgadget"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "x11 systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"

IMAGE_INSTALL_append = " i2c-tools nano bash-completion devmem2 fbset imagemagick vim usb-modeswitch picocom glmark2 iperf iw rfkill iotop libmodbus gtk+ gtkhtml2 fbgrab gtkperf fsl-gpu-sdk eglinfo-x11 piglit gst-plugins-base gst-fsl-plugin gstreamer1.0-plugins-imx gst-plugins-gl hostap-daemon libsocketcan canutils alsa-utils alsa-state v4l-utils qt-in-industrial-embedded-smarthome qt4-x11-free xinput-calibrator gst-plugins-base-meta gst-plugins-good-meta gst-plugins-bad-meta gst-plugins-gl wvdial ppp boost libusb1 openssh wpa-supplicant iproute2 wireless-tools avahi nfs-utils"

# apache2 maliit-framework-qt5 cinematicexperience bluez