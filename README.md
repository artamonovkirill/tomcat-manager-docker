# Tomcat Manager in Docker [![Build Status](https://travis-ci.org/artamonovkirill/tomcat-manager-docker.svg?branch=master)](https://travis-ci.org/artamonovkirill/tomcat-manager-docker)

This repository serves as a test, and an example of configuring Tomcat Manager for Tomcat Docker images. 

## Configuration

Manager app configuration: [manager.xml](./src/main/resources/manager.xml).

Users config: [users.xml](./src/main/resources/users.xml).

Locations to copy xmls mentioned above can be found in [TomcatSpec](./src/test/groovy/TomcatSpec.groovy).  
