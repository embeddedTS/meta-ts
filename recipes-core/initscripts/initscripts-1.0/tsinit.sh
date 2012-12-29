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

cp -P /initrd/dev/tsconsole /dev/tsconsole

