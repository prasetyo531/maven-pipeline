#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - 10.10.10.241"

while [ "$( curl -s http://localhost:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp seleniumDocker-1.0.0.jar:seleniumDocker-1.0.0-tests.jar:libs/*:classes:*resources/* \
    org.testng.TestNG $MODULE