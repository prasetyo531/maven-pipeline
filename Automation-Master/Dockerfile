FROM openjdk:13-ea-19-jdk-alpine3.9


# Workspace
WORKDIR /usr/share/udemy

ADD target/seleniumDocker-1.0.0.jar                                  seleniumDocker-1.0.0.jar.jar
ADD target/seleniumDocker-1.0.0-tests.jar                            seleniumDocker-1.0.0-tests.jar
ADD target/libs                                                      libs
ADD target/classes                                                   classes
ADD target/classes/resources/Controller.class                        resources/Controller.class
ADD target/src_controller/resources/data.properties                  src_controller/resources/data.properties

# in case of any other depedency
# please add that as well

# add ssuite files
ADD testng.xml                           testng.xml


ENTRYPOINT java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* org.testng.TestNG testng.xml