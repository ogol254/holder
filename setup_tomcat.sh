useradd -m -U -d /opt/tomcat -s /bin/false tomcat

cd /tmp

wget https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.42/bin/apache-tomcat-8.5.42.zip
unzip apache-tomcat-*.zip
mkdir -p /opt/tomcat
mv apache-tomcat-8.5.42 /opt/tomcat/
ln -s /opt/tomcat/apache-tomcat-8.5.42 /opt/tomcat/latest
chown -R tomcat: /opt/tomcat 
sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'

rm -f /opt/tomcat/latest/conf/tomcat-users.xml
cp tomcat-users.xml /opt/tomcat/latest/conf/

cp tomcat.service /etc/systemd/system/

echo "Realoading deamon ..........."
systemctl daemon-reload

echo "Starting tomcat ..........."
systemctl start tomcat

echo "Enabling tomcat  ..........."
systemctl enable tomcat

echo "Done with Tomcat ................."

