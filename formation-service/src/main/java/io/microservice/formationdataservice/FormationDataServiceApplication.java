package io.microservice.formationdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class FormationDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationDataServiceApplication.class, args);
    }

}
