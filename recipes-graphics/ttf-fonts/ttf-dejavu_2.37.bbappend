do_install() {
    install -d ${D}${libdir}/fonts/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}${libdir}/fonts/ \;
    install -d ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/30-dejavu-aliases.conf ${D}${sysconfdir}/fonts/conf.d/
}

FILES_${PN}-sans            = "${libdir}/fonts/DejaVuSans.ttf ${libdir}/fonts/DejaVuSans-*.ttf"
FILES_${PN}-sans-mono       = "${libdir}/fonts/DejaVuSansMono*.ttf"
FILES_${PN}-sans-condensed  = "${libdir}/fonts/DejaVuSansCondensed*.ttf"
FILES_${PN}-serif           = "${libdir}/fonts/DejaVuSerif.ttf ${libdir}/fonts/DejaVuSerif-*.ttf"
FILES_${PN}-serif-condensed = "${libdir}/fonts/DejaVuSerifCondensed*.ttf"
FILES_${PN}-mathtexgyre     = "${libdir}/fonts/DejaVuMathTeXGyre.ttf"

