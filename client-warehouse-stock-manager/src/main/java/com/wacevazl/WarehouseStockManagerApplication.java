package com.wacevazl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication()
public class WarehouseStockManagerApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(WarehouseStockManagerApplication.class);

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.author}")
    private String applicationAuthor;

    @Value("${application.creation.date}")
    private String applicationCreatedDate;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarehouseStockManagerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WarehouseStockManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {

            LocalDate dateAppWasCreated = LocalDate.parse(applicationCreatedDate);
            log.info("{} was created on {} by {}", applicationName, dateAppWasCreated, applicationAuthor);
            log.info("List of beans provided by Spring Boot:");

            String[] beanNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info("Bean provided by Spring Boot: {}", beanName);
            }
        };
    }
}
