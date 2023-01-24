## TRAINING DEMO APPLICATION 
## Java based application to Demonstrate :
* How unit test cases execute via maven
* Generate a test report
* Build an Artifact 


### Pre-Reqs

### Install following software on your machine

Software dependencies are:
* JDK 1.8 or higher
* Maven

Development dependencies are:
* IntelliJ (Community Edition) or Similar IDE
* GIT

# Once installation is done please run following commands:-

* mvn clean install (for installing all the dependencies)
* java -jar target\JAR_NAME.jar (to execute project)

# Accessing an application
* Deployed Application By-Default can be accessed on port 8081 forexample http://IP_ADDRESS:8081
* This application has two end points :
* Default http://IP_ADDRESS:8081
* User : http://IP_ADDRESS:8081/welcome/<USERNAME>
