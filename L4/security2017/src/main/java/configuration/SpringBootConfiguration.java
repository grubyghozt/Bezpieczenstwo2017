package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"configuration", "controllers", "dao", "services"})
public class SpringBootConfiguration {

    public static void main(String[] args){
        SpringApplication.run(SpringBootConfiguration.class);
    }
}