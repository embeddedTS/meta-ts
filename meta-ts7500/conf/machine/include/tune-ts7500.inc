DEFAULTTUNE ?= "ts7500"

require conf/machine/include/arm/arch-armv4.inc
ABIEXTENESION = "eabi"
TARGET_FPU = "soft"

TUNE_CCARGS += "${@bb.utils.contains("TARGET_FPU", "soft", "-msoft-float", "", d)}"
TUNE_FEATURES_tune-ts7500 = "${TUNE_FEATURES_tune-armv4} no-thumb-interwork"
PACKAGE_EXTRA_ARCHS_tune-ts7500 = "${PACKAGE_EXTRA_ARCHS_tune-armv4}"

