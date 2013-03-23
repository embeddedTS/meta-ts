# fixes for the brken initrd, no /dev/tsconsole
PRINC := "${@int(PRINC) + 1}"
do_install_append() {

	test -c ${D}/dev/ttymxc0 || mknod -m 666 ${D}/dev/ttymxc0 c 207 16
	test -c ${D}/dev/ttymxc1 || mknod -m 666 ${D}/dev/ttymxc1 c 207 17
	test -c ${D}/dev/ttymxc2 || mknod -m 666 ${D}/dev/ttymxc2 c 207 18

}

