# MySQL init script

. /etc/default/rcS

case "$1" in
	start)
         echo -n "Starting mysqld"
		/usr/bin/mysqld_safe > /dev/null 2>&1 &
	    echo "."
        ;;
	stop)
        echo -n "Stopping mysqld"
		if test -f /var/lib/mysql/mysqld.pid ; then
			PID=`cat /var/lib/mysql/mysqld.pid`
			kill $PID
        fi
        echo "."
		;;
	restart)
        echo -n "Restarting mysqld"
		$0 stop
		$0 start
	    echo "."
        ;;
	*)
		echo "Usage: /etc/init.d/mysqld {start|stop|restart}"
		;;
esac

exit 0
