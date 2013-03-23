# disable bootlogd by default
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
PRINC := "${@int(PRINC) + 1}"
do_install_append () {
	echo "BOOTLOGD_ENABLE=no" > ${D}${sysconfdir}/default/bootlogd
}
