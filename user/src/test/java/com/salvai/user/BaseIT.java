package com.salvai.user;

import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
@ActiveProfiles("it")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseIT {

    @Container
    private static final MySQLContainer mysql;

    static {
        mysql = new MySQLContainer<>("mysql:latest")
                .withDatabaseName("playmaker")
                .withUsername("root")
                .withPassword("test_password");

        mysql.start();
        System.setProperty("spring.datasource.url", mysql.getJdbcUrl());
        System.setProperty("spring.datasource.username", mysql.getUsername());
        System.setProperty("spring.datasource.password", mysql.getPassword());
        System.setProperty("spring.datasource.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    }

    @Autowired
    protected TestRestTemplate testRestTemplate;
}