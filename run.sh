#!/bin/bash
# exec /opt/apache-tomcat-8.5.42/bin/catalina.sh run


if [[ ! -d $VOLUME_HOME/mysql ]]; then
    echo "=> An empty or uninitialized MySQL volume is detected in $VOLUME_HOME"
    echo "=> Installing MySQL ..."
    mysqld --initialize-insecure --user=mysql > /dev/null 2>&1
    echo "=> Done!"  
    /create_mysql_admin_user.sh
else
    echo "=> Using an existing volume of MySQL"
fi

echo "=> Starting tomcat ........."

/etc/init.d/mysql start
mysql -u root -ppass < /umls.sql 
exec /opt/tomcat/apache-tomcat-8.5.42/bin/catalina.sh run



