#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

#echo "Checking if hub is ready - 10.10.10.12"
echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* \
    DHUB_HOST=$HUB_HOST \
    org.testng.TestNG $MODULE