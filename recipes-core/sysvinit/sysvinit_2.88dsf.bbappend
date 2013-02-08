# disable bootlogd by default
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_append () {
	echo "BOOTLOGD_ENABLE=no" > ${D}${sysconfdir}/default/bootlogd
}
