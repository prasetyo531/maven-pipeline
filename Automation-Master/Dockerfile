FROM openjdk:13-ea-19-jdk-alpine3.9

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

ADD target/seleniumDocker-1.0.0.jar                                  seleniumDocker-1.0.0.jar.jar
ADD target/seleniumDocker-1.0.0-tests.jar                            seleniumDocker-1.0.0-tests.jar
ADD target/libs                                                      libs
#ADD target/classes                                                   classes
ADD target/classes/resources/Controller.class                        resources/Controller.class
ADD target/src_controller/resources/data.properties                  src_controller/resources/data.properties

# in case of any other depedency
# please add that as well

#host machine url1
#host machine url2
#host machine url3

# add ssuite files
ADD testng.xml                           testng.xml

#add healthcheck file
ADD healthcheck.sh                       healthcheck.sh

ENTRYPOINT sh healthcheck.sh

#ENTRYPOINT java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* org.testng.TestNG testng.xml
ENTRYPOINT java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* org.testng.TestNG $MODULE