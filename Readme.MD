Goal
====
Produce a simple web-app to do a CRUD operation.

Requirement
--------------
Create a Java-based REST API that:

1. Creates a new company.
2. Get a list of all the companies.
3. Get detail about a company.
4. Ability to update the company details.
5. Able to add beneficial owner(s) of the company.

Create a UI which will use those rest endpoint and would be used to interact with the user.

Instructions to build and run the application.
---------------------------------------------

##### Pre-requisite for this project:
	- Install Java8 using the instruction mentioned https://www.ntu.edu.sg/home/ehchua/programming/howto/JDK_HowTo.html
	- Install Maven using the instruction mentioned https://maven.apache.org/install.html
	- Install Git using https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
	
##### To build the application:
  	- Clone the repository using "git clone https://github.com/eralmas7/SpringBootWithAngular.git" command.
  	- After cloning, goto the directory SpringBootWithAngular where we checked out the project.
  	- Once done, you could create executable jar using "mvn package"
  	- Once done, you should be able to run the application using "java -jar target/*.jar"
  	
##### highlights of this project:
	1. Based on SOLID design principle.
	2. Monitoring is available https://samplecompany.herokuapp.com/health
	3. Added JBheave acceptance test, Integration test, unit tests.
	4. Uses Spring data to perform CRUD operations.

##### How can i extend service to support security:

	1. Add the following dependency in pom.xml (under dependancies tag) which is at the root of the Git project.
           <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
          </dependency>
	2. Add the security config similar to one created by me https://github.com/eralmas7/Currency-Coverter-app/blob/master/src/main/java/com/currency/converter/client/config/SecurityConfig.java
	3. Add initial sql script which would create a user in resources folder like https://github.com/eralmas7/Currency-Coverter-app/blob/master/src/main/resources/data.sql
	4. Create a domain class for user like https://github.com/eralmas7/Currency-Coverter-app/blob/master/src/main/java/com/currency/converter/domain/User.java
	5. Handle login/logout functionality as created by me https://github.com/eralmas7/Currency-Coverter-app/blob/master/src/main/webapp/WEB-INF/ftl/home.ftl

##### How could i scale this application:

	1. Since this application depends on inmemory database to store the state, we should move to mysql which would be a common data source.
	2. We should be behind the load balancer or router (like apache camel router/redirector or zookeper) to route the request from centralized location to appropriate service instances.

##### Assumptions:

	1. Companies are just present at one location and have one contact information.

##### Technologies used to build backend services:

	1. Java 8
	2. Spring Boot framework
	3. Spring Data
	4. JBehave, Junit, Mockito, Spring-Test
	5. H2
	6. Tomcat
	7. Maven

##### Technologies used to build front end services:

	1. Bootstrap
	2. Angular JS
	3. Html 5

##### Services used or deployed to:

	- Cloud - https://samplecompany.herokuapp.com
	- CI - https://travis-ci.org/eralmas7/SpringBootWithAngular