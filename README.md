Steps:

1. start.spring.io and configure based on 'springboot-initializer' image

2. once generated, unzip the file, then you'll have 'springboot-file-structure' image

3. 'pom.xml' is like 'package.json' with all the dependencies (DON'T TOUCH IT!)

4. to start up server,

   a. click 'run' ONLY on the 'main' function in ./main/java/......./Application.java
   OR
   b. type './mvnw spring-boot:run' in the directory

Technologies used:

- SpringBoot
- Maven
- Docker
- PostgreSQL
- Flyway

Video Reference: https://www.youtube.com/watch?v=vtPkZShrvXQ

http://localhost:8080/api/v1/person

- check java version === javac --version
