package org.lab.biblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"Controller", "data", "model"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "data")
public class BibliotekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotekaApplication.class, args);
    }

}
