# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2018 (C) O.S. Systems Software LTDA.
# Copyright 2017-2024 NXP

require recipes-bsp/u-boot/u-boot.inc
require u-boot-ts-common_${PV}.inc

PROVIDES += "u-boot"

#inherit uuu_bootloader_tag
#UUU_BOOTLOADER                        = ""
#UUU_BOOTLOADER_TAGGED                 = ""
#UUU_BOOTLOADER_UNTAGGED                 = ""

do_deploy:append:mx93-generic-bsp() {
    # Deploy CRT.* from u-boot for stmm
    install -m 0644 ${S}/CRT.*     ${DEPLOYDIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(tsimx9)"
