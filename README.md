# Tomcat Manager in Docker [![Gradle](https://github.com/artamonovkirill/tomcat-manager-docker/actions/workflows/gradle.yml/badge.svg)](https://github.com/artamonovkirill/tomcat-manager-docker/actions/workflows/gradle.yml)

This repository serves as a test, and an example of configuring Tomcat Manager for Tomcat Docker images. 

## Configuration

Manager app configuration: [manager.xml](./src/main/resources/manager.xml).

Users config: [users.xml](./src/main/resources/users.xml).

Locations to copy xmls mentioned above can be found in [TomcatSpec](./src/test/groovy/TomcatSpec.groovy).  
