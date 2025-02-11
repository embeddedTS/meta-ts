SUMMARY = "TS-4100 system utilities"
HOMEPAGE = "http://www.embeddedTS.com/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0deb455fa485cd99c8fd0344ea4b23b4"

# Note that libgpiod < 2.x is needed
DEPENDS = " libgpiod zpu-elf-gcc-native"
# If this machine has tssilo support enabled, then we need the startup script.
# Since the tssilomon script uses libgpiod-tools, that also is needed at runtime
RDEPENDS:${PN} += "${@bb.utils.contains('MACHINE_FEATURES', 'tssilo', 'tssilomon-start libgpiod-tools', '', d)}"

BRANCH = "master"

SRC_URI = "git://github.com/embeddedTS/ts4100-utils.git;protocol=https;branch=${BRANCH}"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

# The zpu-elf-gcc-native recipe installs the toolchain to ${base_bindir}/zpu-elf-gcc/
# and the actual executable is within bin/ of that folder.
# Note that, there does not appear to be a way for a recipe to add arbitrary
# directories to $PATH that future recipes would use. So, any recipe using the
# ZPU toolchain needs to specify this directly.
EXTRANATIVEPATH = "zpu-elf-gcc/bin"

do_compile:append() {
	if ! [ -x "$(command -v zpu-elf-gcc)" ]; then
		bbwarn "Native ZPU compiler not found, not building ZPU binaries"
		exit 0
	else
		cd "${S}/src/zpu/"
		make
	fi
}

do_install:append() {
	if [ -x "$(command -v zpu-elf-gcc)" ]; then
		install -d "${D}${base_bindir}/zpu"
		install -m 0644 "${S}/src/zpu/zpu_muxbus.bin" "${D}${base_bindir}/zpu"
		install -m 0644 "${S}/src/zpu/zpu_demo.bin" "${D}${base_bindir}/zpu"
	fi
}

inherit autotools pkgconfig

FILES:${PN} += "${base_bindir}/zpu"
