# image_dd.bbclass
# (loosly based off bootimg.bbclass Copyright (C) 2004, Advanced Micro Devices, Inc.)
#
# Create an image which can be placed directly onto a harddisk using dd and then
# booted.
#

PACKAGES = " "
EXCLUDE_FROM_WORLD = "1"

#DD_MBR_IMAGE ?= "mbr-flash.dd"		
#DD_INITRD_IMAGE ?= "initrd-flash.dd"		
#DD_IMAGE_SIZE ?= "524288"
#DD_OFFSET_INITRD ?= "4096"
#DD_OFFSET_ROOTFS ?= "8192" 

DD_VFAT_DUMMY ?= "0"

build_image_dd() {
	IMAGE=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.dd

	rm -rf $IMAGE
	
	dd if=/dev/zero of=$IMAGE bs=512 count=${DD_IMAGE_SIZE}
	dd if=${STAGING_DIR_TARGET}/usr/share/ts-image-support/${DD_MBR_IMAGE} of=$IMAGE conv=notrunc seek=0 bs=512
	if [ "${DD_VFAT_DUMMY}" = "1" ]; then
		dd if=${STAGING_DIR_TARGET}/usr/share/ts-image-support/vfatdummy.dd of=$IMAGE conv=notrunc seek=1  bs=512
	fi
	dd if=${STAGING_KERNEL_DIR}/zImage of=$IMAGE conv=notrunc seek=${DD_OFFSET_KERNEL}  bs=512
	dd if=${STAGING_DIR_TARGET}/usr/share/ts-image-support/${DD_INITRD_IMAGE} of=$IMAGE conv=notrunc seek=${DD_OFFSET_INITRD} bs=512
	dd if=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext2 of=$IMAGE conv=notrunc seek=${DD_OFFSET_ROOTFS} bs=512

} 

python do_ddimage() {
    bb.build.exec_func('build_image_dd', d)
}

addtask do_ddimage before do_build after do_rootfs
do_ddimage[depends] += "ts-image-support:do_populate_sysroot"
do_ddimage[depends] += "${IMAGE_BASENAME}:do_rootfs"
do_ddimage[nostamp] = "1"


