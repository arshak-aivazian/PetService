package com.example.userservice.integration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class AbstractTestcontainerTest {

    private final static KafkaContainer kafkacontainer;
    private final static PostgreSQLContainer postgresContainer;

    static {
        kafkacontainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
        kafkacontainer.start();

        postgresContainer = new PostgreSQLContainer(DockerImageName.parse("postgres:11.1"));
        postgresContainer.start();
    }

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers",kafkacontainer::getBootstrapServers);

        registry.add("spring.datasource.url",postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username",postgresContainer::getUsername);
        registry.add("spring.datasource.password",postgresContainer::getPassword);
    }
}
