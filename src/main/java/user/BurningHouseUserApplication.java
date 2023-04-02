package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableJpaAuditing
@Configuration
@EnableScheduling
@EnableCaching
public class BurningHouseUserApplication {

        public static void main(String[] args) {
        SpringApplication.run(BurningHouseUserApplication.class, args);
    }

}
