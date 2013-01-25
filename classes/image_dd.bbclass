# image_dd.bbclass
# (loosly based off bootimg.bbclass Copyright (C) 2004, Advanced Micro Devices, Inc.)
#
# Create an image which can be placed directly onto a harddisk using dd and then
# booted.
#
# This uses syslinux. extlinux would have been nice but required the ext2/3 
# partition to be mounted. grub requires to run itself as part of the install 
# process.
#
# The end result is a 512 boot sector populated with an MBR and partition table
# followed by an msdos fat16 partition containing syslinux and a linux kernel
# completed by the ext2/3 rootfs.
#
# We have to push the msdos parition table size > 16MB so fat 16 is used as parted
# won't touch fat12 partitions.

# External variables needed

# ${ROOTFS} - the rootfs image to incorporate


PACKAGES = " "
EXCLUDE_FROM_WORLD = "1"

DD_MBR_IMAGE ?= "mbr-flash.dd"		
DD_INITRD_IMAGE ?= "initrd-flash.dd"		
DD_IMAGE_SIZE ?= "524288"
DD_OFFSET_INITRD ?= "4096"
DD_OFFSET_ROOTFS ?= "8192" 

build_image_dd() {
	IMAGE=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.dd

	rm -rf $IMAGE
	dd if=/dev/zero of=$IMAGE bs=512 count=${DD_IMAGE_SIZE}
	dd if=${STAGING_DIR_TARGET}/usr/share/ts-image-support/${DD_MBR_IMAGE} of=$IMAGE conv=notrunc seek=0 bs=512
	dd if=${STAGING_KERNEL_DIR}/zImage of=$IMAGE conv=notrunc seek=1 bs=512
	dd if=${STAGING_DIR_TARGET}/usr/share/ts-image-support/${DD_INITRD_IMAGE} of=$IMAGE conv=notrunc seek=${DD_OFFSET_INITRD} bs=512
	dd if=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3 of=$IMAGE conv=notrunc seek=${DD_OFFSET_ROOTFS} bs=512

} 

python do_ddimage() {
    bb.build.exec_func('build_image_dd', d)
}

addtask do_ddimage before do_build after do_rootfs
do_ddimage[depends] += "ts-image-support:do_populate_sysroot"
do_ddimage[depends] += "${IMAGE_BASENAME}:do_rootfs"
do_ddimage[nostamp] = "1"


