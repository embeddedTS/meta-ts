# remove the udev automount feature because of problems with the ts nbd devices

do_install_append() {

    rm -f ${D}${sysconfdir}/udev/rules.d/automount.rules
    rm -f ${D}${sysconfdir}/udev/scripts/mount.sh
}

