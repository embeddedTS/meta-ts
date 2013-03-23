FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://interfaces "
PRINC := "${@int(PRINC) + 1}"
