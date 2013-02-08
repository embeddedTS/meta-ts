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

test -e /dev/tsconsole || cp -P /initrd/dev/tsconsole /dev/tsconsole

rdev="$(mountpoint -d /)"
mknod -m 600 /dev/rootdev b ${rdev%:*} ${rdev#*:}
