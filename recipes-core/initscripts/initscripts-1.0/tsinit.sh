#!/bin/sh
### BEGIN INIT INFO
# Provides:         tsinit 
# Required-Start:    
# Required-Stop:     
# Default-Start:     0
# Default-Stop:      
# Short-Description: TS specific initialization stuff
# Description: 
### END INIT INFO

test -e /initrd/dev/tsconsole && cp -P /initrd/dev/tsconsole /dev/tsconsole
# ts4800 console fix
test -e /dev/ttymxc0 && ln -s /dev/ttymxc0 /dev/tsconsole

rdev="$(mountpoint -d /)"
mknod -m 600 /dev/rootdev b ${rdev%:*} ${rdev#*:}
