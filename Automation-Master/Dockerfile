FROM openjdk:8u212-jre-alpine3.9


# Workspace
WORKDIR /usr/share/udemy

ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs


# in case of any other depedency
# please add that as well

# add ssuite files
ADD testng.xml                           testng.xml


ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE