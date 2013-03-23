PR = "r4"

SRC_URI += " \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/xnand-mbr-latest.dd.bz2;name=mbr-flash;downloadfilename=mbr-flash.dd.bz2 \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/initrd-busybox-rootfs-latest.dd.bz2;name=initrd-flash;downloadfilename=initrd-flash.dd.bz2 \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/sd-mbr-feb042013.dd.bz2;name=mbr-sd;downloadfilename=mbr-sd.dd.bz2 \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/initrd-busybox-rootfs-latest.dd.bz2;name=initrd-sd;downloadfilename=initrd-sd.dd.bz2 \
	\
	"
SRC_URI[mbr-flash.md5sum] = "c54b1ac6342ba3ed8f8fab120023b76f"
SRC_URI[mbr-flash.sha256sum] = "eb74a29ecf43fc91322465e1fda0ac3b9332e6aa559c3949abeda78ac47724a1"
SRC_URI[initrd-flash.md5sum] = "4e8d353fa8c9c88f9a43ed1714bacda6"
SRC_URI[initrd-flash.sha256sum] = "e97dcd791a07e45579f97fecd6d2667af26bc6751c574eb51c5d5e9b3b9ba09e"

SRC_URI[mbr-sd.md5sum] = "65692ae0ef6969ca7f11e7049b0be079"
SRC_URI[mbr-sd.sha256sum] = "5251c863887d1cad9b71c877a83fe5d0165ed27a0865f7e14df0e372a4b85139"
SRC_URI[initrd-sd.md5sum] = "4e8d353fa8c9c88f9a43ed1714bacda6"
SRC_URI[initrd-sd.sha256sum] = "e97dcd791a07e45579f97fecd6d2667af26bc6751c574eb51c5d5e9b3b9ba09e"
PRINC := "${@int(PRINC) + 1}"
