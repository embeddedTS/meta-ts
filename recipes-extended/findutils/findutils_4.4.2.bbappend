# patch 01-27017.patch exchanged with an empty one, because it cause segementation faults 
# on the ts7500 and there is no real benefit for us
FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

