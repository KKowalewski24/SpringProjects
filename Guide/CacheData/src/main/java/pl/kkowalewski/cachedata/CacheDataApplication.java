package pl.kkowalewski.cachedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheDataApplication.class, args);
    }

}
