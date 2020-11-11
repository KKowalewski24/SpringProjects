package pl.kkowalewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource("classpath:chuck-config.xml") -> USE FOR XML CONFIG
@SpringBootApplication
public class JokesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokesAppApplication.class, args);
    }

}
