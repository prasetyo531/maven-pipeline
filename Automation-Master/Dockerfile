FROM openjdk:8u212-jre-alpine3.9


# Workspace
WORKDIR /usr/share/udemy

ADD target/selenium-docker-1.0.0.jar                                  selenium-docker-1.0.0.jar.jar
ADD target/selenium-docker-1.0.0-tests.jar                            selenium-docker-1.0.0-tests.jar
ADD target/libs                                                       libs
ADD target/classes/resources/Controller.class                         src_controller/resources/Controller.class
ADD target/src_controller/resources/data.properties                   src_controller/resources/data.properties

# in case of any other depedency
# please add that as well

# add ssuite files
ADD testng.xml                           testng.xml


ENTRYPOINT java -cp selenium-docker-1.0.0.jar:selenium-docker-1.0.0-tests.jar:libs/* org.testng.TestNG org.testng.TestNG testng.xml