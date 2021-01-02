echo "starting db  ................."

service mysql restart
exec /etc/init.d/mysql start

echo "DB RUNNING   ................."

mysql -uroot  -e "CREATE DATABASE umls CHARACTER SET UTF8"

# echo "=> First set up "
# mysql -u root umls < /tmp/01_setup.sql 
# echo "=> 2nd set up "
# mysql -u root umls < /tmp/02_load.sql 
# echo "=> 3rd set up ....."
# mysql -u root umls < /tmp/03_load.sql 
# echo "=> 4th set up  ....."
# mysql -u root umls < /tmp/04_load.sql 
# echo "=> 5th set up  ....."
# mysql -u root umls < /tmp/05_load.sql 
# echo "=> 6th set up  ....."
# mysql -u root umls < /tmp/06_load.sql 
# echo "=> 7th set up  ....."
# mysql -u root umls < /tmp/07_load.sql 
# echo "=> 8th set up  ....."
# mysql -u root umls < /tmp/08_load.sql 

echo "setting password "

mysql -uroot -ppass -e "SET PASSWORD FOR root@localhost = 'pass'"

echo  "Loading the database ......"

mysql -u root -ppass < /umls.sql 


echo "Done Loading the databas"