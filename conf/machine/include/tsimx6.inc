ACCEPT_FSL_EULA = "1"

DISTRO_FEATURES_remove = "wayland "
DISTRO_FEATURES_append = " x11 systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.14.imx"
