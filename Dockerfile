FROM ubuntu:16.04

RUN apt-get update 
RUN apt-get install -y maven subversion git unzip wget curl   

# RUN apt-get install -y openjdk-8-jdk

RUN apt-get install -y openjdk-8-jdk openjdk-8-jre-headless default-jdk 



ADD setup_tomcat.sh /setup_tomcat.sh
ADD run.sh /run.sh

ADD supervisord-tomcat.conf /etc/supervisor/conf.d/supervisord-tomcat.conf
RUN chmod 755 /*.sh
RUN /setup_tomcat.sh

# ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

ADD ctakes.sh ./ctakes.sh
RUN chmod +x ./ctakes.sh
RUN ./ctakes.sh


EXPOSE   5000

ENTRYPOINT ["/run.sh"]