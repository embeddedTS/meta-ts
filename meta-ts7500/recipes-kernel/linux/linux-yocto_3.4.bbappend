FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR := "${PR}.1"

COMPATIBLE_MACHINE_ts7500 = "ts7500"


KBRANCH_DEFAULT_ts7500  = "standard/ts7500"
KBRANCH_ts7500  = "${KBRANCH_DEFAULT}"

KMACHINE_ts7500  = "ts7500"


SRC_URI += "file://ts7500-standard.scc \
            file://ts7500.scc \
            file://ts7500.cfg \
            file://user-config.cfg \
            file://user-patches.scc \
           "

# uncomment and replace these SRCREVs with the real commit ids once you've had
# the appropriate changes committed to the upstream linux-yocto repo
#SRCREV_machine_pn-linux-yocto_ts7500 ?= "19f7e43b54aef08d58135ed2a897d77b624b320a"
#SRCREV_meta_pn-linux-yocto_ts7500 ?= "459165c1dd61c4e843c36e6a1abeb30949a20ba7"
