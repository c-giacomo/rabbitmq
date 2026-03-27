package com.rabbitmq.rabbitmq.topic.exchange;

import com.rabbitmq.rabbitmq.topic.exchange.service.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitmqTopicExchangeApplication implements CommandLineRunner {

    private final TopicProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTopicExchangeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.send();
    }
}
