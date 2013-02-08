#!/bin/sh
### BEGIN INIT INFO
# Provides:          checkroot
# Required-Start:    udev tsinit
# Required-Stop:     
# Default-Start:     S
# Default-Stop:
# Short-Description: Check to root file system.
### END INIT INFO

. /etc/default/rcS

#
# Set SULOGIN in /etc/default/rcS to yes if you want a sulogin to be spawned
# from this script *before anything else* with a timeout, like SCO does.
#
test "$SULOGIN" = yes && sulogin -t 30 $CONSOLE

rootmode=rw
rootopts=rw
rootcheck=no
test $ENABLE_ROOTFS_FSCK = yes && rootcheck=yes

#
# Check the root filesystem.
#
if test -f /fastboot || test $rootcheck = no
then
  test $rootcheck = yes && echo "Fast boot, no filesystem check"
else
  #
  # Ensure that root is quiescent and read-only before fsck'ing.
  #
  mount -n -o remount,ro /
  if test $? = 0
  then
    if test -f /forcefsck
    then
	force="-f"
    else
	force=""
    fi
    if test "$FSCKFIX" = yes
    then
	fix="-y"
    else
	fix="-a"
    fi
    test "$VERBOSE" != no && echo "Checking root filesystem..."
    fsck.ext2  $force $fix /dev/rootdev
    #
    # If there was a failure, drop into single-user mode.
    #
    # NOTE: "failure" is defined as exiting with a return code of
    # 2 or larger.  A return code of 1 indicates that filesystem
    # errors were corrected but that the boot may proceed.
    #
    if test "$?" -gt 1
    then
      # Surprise! Re-directing from a HERE document (as in
      # "cat << EOF") won't work, because the root is read-only.
      echo
      echo "fsck failed.  Please repair manually and reboot.  Please note"
      echo "that the root filesystem is currently mounted read-only.  To"
      echo "remount it read-write:"
      echo
      echo "   # mount -n -o remount,rw /"
      echo
      echo "CONTROL-D will exit from this shell and REBOOT the system."
      echo
      # Start a single user shell on the console
      /sbin/sulogin -t 10 $CONSOLE
      reboot -f
    fi
  else
    echo "*** ERROR!  Cannot fsck root fs because it is not mounted read-only!"
    echo
  fi
fi

#
#	If the root filesystem was not marked as read-only in /etc/fstab,
#	remount the rootfs rw but do not try to change mtab because it
#	is on a ro fs until the remount succeeded. Then clean up old mtabs
#	and finally write the new mtab.
#
mount -n -o remount,$rootmode /
if test "$rootmode" = rw
then
	ln -sf /proc/mounts /dev/mtab
fi

: exit 0
