git clone https://github.com/GoTeamEpsilon/ctakes-rest-service.git
cd ctakes-rest-service
mkdir ctakes-codebase-area
cd ctakes-codebase-area
svn export 'https://svn.apache.org/repos/asf/ctakes/trunk'
cd trunk/ctakes-distribution
mvn install -Dmaven.test.skip=true
cd ../ctakes-assertion-zoner
mvn install -Dmaven.test.skip=true
cd ../../../ctakes-web-rest
mvn install










mv target/ctakes-web-rest.war /opt/tomcat/latest/webapps/