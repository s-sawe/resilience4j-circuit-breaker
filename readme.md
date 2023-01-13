RESILIENCE4J
. It is a fault tolerance library
. Requires Java 17

The dependencies required are:

        <!--HEALTH OF MICROSERVICES-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--SENDS METRICS TO ACTUATOR TO TRACK THE STATUS OF THE CIRCUIT BREAKER-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <!--TO IMPLEMENT CIRCUIT-BREAKER PATTERN-->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot2</artifactId>
            <version>1.5.0</version>
        </dependency>

The Features and Modules of Resilience4j are:
. Circuit Breaker - Fault tolerance
. Rate Limiter - Blocks too frequent requests
. Time Limiter - Sets a time limit when calling a remote application
. Retry Mechanism - Automatic retrying (sync & async)
. Bulkhead - Avoids too many concurrent requests
. Cache - Stores the results of a costly remote operations