package com.wacevazl;

import com.wacevazl.security.EncryptPassword;
import com.wacevazl.security.GeneratePassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class },
        scanBasePackages="com.wacevazl")
public class WarehouseStockManagerApplication {

    @Autowired
    GeneratePassword generatePassword;

    @Autowired
    EncryptPassword encryptPassword;

    private static final Logger log = LoggerFactory.getLogger(WarehouseStockManagerApplication.class);

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.author}")
    private String applicationAuthor;

    @Value("${application.creation.date}")
    private String applicationCreatedDate;

    @Value("${application.plaintextpassword}")
    private String plainTextPassword;

    public static void main(String[] args) {
        SpringApplication.run(WarehouseStockManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {

            LocalDate dateAppWasCreated = LocalDate.parse(applicationCreatedDate);
            log.info("{} was created on {} by {}", applicationName, dateAppWasCreated, applicationAuthor);
            log.info("List of beans provided by Spring Boot:");

            log.info("***************************************************************************************************");
            log.info("Password: {} Encryption: {}", plainTextPassword, encryptPassword.hashPassword(plainTextPassword));
            log.info("***************************************************************************************************");

            String randomlyGeneratedPassword = generatePassword.generateRandomPassword(8);

            log.info("***************************************************************************************************");
            log.info("Password randomly generated: {} Encryption: {}", randomlyGeneratedPassword, encryptPassword.hashPassword(randomlyGeneratedPassword));
            log.info("***************************************************************************************************");

            String[] beanNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info("Bean provided by Spring Boot: {}", beanName);
            }
        };
    }
}
