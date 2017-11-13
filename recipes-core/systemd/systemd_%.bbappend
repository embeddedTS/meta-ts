PACKAGECONFIG_append = " networkd resolved timedated timesyncd"

# Do not FSCK on first boot.  This will cause the bootlimit to trip
EXTRA_OECONF += "--with-time-epoch=0"

do_install_append() {
	ln -s ../run/systemd/resolve/resolv.conf ${D}${sysconfdir}/resolv.conf
}
