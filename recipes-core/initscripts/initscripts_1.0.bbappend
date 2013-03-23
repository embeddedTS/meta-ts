FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI_append = " file://tsinit.sh "
PRINC := "${@int(PRINC) + 1}"

do_install_append () {

	install -m 0755 ${WORKDIR}/tsinit.sh	${D}${sysconfdir}/init.d
	ln -sf	../init.d/tsinit.sh	${D}${sysconfdir}/rcS.d/S09tsinit.sh
}

