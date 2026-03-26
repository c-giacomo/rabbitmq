package com.rabbitmq.def.exchange;

import com.rabbitmq.def.exchange.service.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitMQDefaultApplication implements CommandLineRunner {

    private final MessageProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQDefaultApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.inviaMessaggio();
        producer.inviaMessaggioUser();
    }
}