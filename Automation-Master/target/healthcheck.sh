#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

while [ "$( curl -s http://10.10.10.12:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	echo ulang lagi.
	sleep 1
done

if [ "$( curl -s http://10.10.10.12:4444/wd/hub/status | jq -r .value.ready )" == "true" ]
then
	echo node ready.
fi


# start the java command
# java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* \
#     org.testng.TestNG $MODULE