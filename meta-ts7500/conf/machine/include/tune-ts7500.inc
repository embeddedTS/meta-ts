DEFAULTTUNE ?= "ts7500"

require conf/machine/include/arm/arch-armv4.inc
ABIEXTENESION = "eabi"
TARGET_FPU = "soft"
TUNEVALID[ts7500] = "Enable ts7500 specific processor optimizations(no thumb, soft fload)"
ARM_INSTRUCTION_SET = "arm"
TUNE_CCARGS += "${@bb.utils.contains("TUNE_FEATURES", "ts7500", "-marm -mfloat-abi=soft", "", d)}"

AVAILTUNES += "ts7500"
TUNE_FEATURES_tune-ts7500 = "${TUNE_FEATURES_tune-armv4} no-thumb-interwork ts7500"
PACKAGE_EXTRA_ARCHS_tune-ts7500 = "${PACKAGE_EXTRA_ARCHS_tune-armv4}"

