package pl.kkowalewski.circuitbreakerreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class CircuitBreakerReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerReaderApplication.class, args);
    }

}
