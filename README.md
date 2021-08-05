JPAstreamer example
Table of Contents
Introduction
What is JPAstreamer =
How does JPAstreamer work with Spring Boot?
How does it run?
How does it check?
Introduction
In this simple example we are going to see how to use java streams with JPA thanks to JPAstreamer.

If you want to take a look this example with more information go to: https://refactorizando.com/jpa-queries-streams-java

What is JPAstreamer =
JPAstreamer is a library for expressing JPA/Hibernate/Spring queries using standard Java streams. JPAstreamer instantly gives Java developers type-safe, expressive and intuitive means of obtaining data in database applications.

How does JPAstreamer work with Spring Boot?
To use JPAstreamer together with Spring Boot we need to add maven dependencies and inject as dependency JPAStreamer in every class that we want to use it.

To work with JPAstreamer in our classes we are going to use it as Java Stream. For example if we want to find all records of car entity we are going to do:

jpaStreamer.stream(Car.class)
              .collect(Collectors.toList());
We also have to keep in mind that we need spring-boot-starter-data-jpa.

How does it run?
This is a spring boot application so to run it you can run with maven:

mvn spring-boot:run
from your IDE running the class

JpastreamerExampleApplication
or running your *.jar

java -jar *.jar
How does it check?
We have some endpoints with GET to verify and check this example:

http://localhost:8090/brand/
http://localhost:8090/brand/{id}
http://localhost:8090/brand?name={Name}

http://localhost:8090/car/{id}
http://localhost:8090/car

Examples:
http://localhost:8090/brand/2
http://localhost:8090/brand?name=Mercedes
http://localhost:8090/car/1
