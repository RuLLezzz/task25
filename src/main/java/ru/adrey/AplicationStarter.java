package ru.adrey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by AA.Gorbachev on 08.02.2018.
 */
@SpringBootApplication
@ImportResource(value = "context.xml")
@ComponentScan("ru.adrey")
public class AplicationStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AplicationStarter.class);
    }
}
