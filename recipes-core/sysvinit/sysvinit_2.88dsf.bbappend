# disable bootlogd by default

do_install_append () {
	echo "BOOTLOGD_ENABLE=no" > ${D}${sysconfdir}/default/bootlogd
}
