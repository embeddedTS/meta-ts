PR = "r0"

SRC_URI = " \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/xnand-mbr-latest.dd.bz2;name=mbr-flash;downloadfilename=mbr-flash.dd.bz2 \
ftp://ftp.embeddedarm.com/ts-arm-sbc/ts-7500-linux/binaries/ts-images/initrd-busybox-rootfs-latest.dd.bz2;name=initrd-flash;downloadfilename=initrd-flash.dd.bz2 \
	\
	"
SRC_URI[mbr-flash.md5sum] = "c54b1ac6342ba3ed8f8fab120023b76f"
SRC_URI[mbr-flash.sha256sum] = "eb74a29ecf43fc91322465e1fda0ac3b9332e6aa559c3949abeda78ac47724a1"
SRC_URI[initrd-flash.md5sum] = "4e8d353fa8c9c88f9a43ed1714bacda6"
SRC_URI[initrd-flash.sha256sum] = "e97dcd791a07e45579f97fecd6d2667af26bc6751c574eb51c5d5e9b3b9ba09e"

