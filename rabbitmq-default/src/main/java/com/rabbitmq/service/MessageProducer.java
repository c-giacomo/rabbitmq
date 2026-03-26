package com.rabbitmq.service;

import com.rabbitmq.configuration.RabbitMQConfiguration;
import com.rabbitmq.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void inviaMessaggio() {
        rabbitTemplate.convertAndSend(
                "",
                RabbitMQConfiguration.TEST_QUEUE,
                "messaggio"
        );
    }

    public void inviaMessaggioUser() {
        rabbitTemplate.convertAndSend(
                "",
                RabbitMQConfiguration.TEST_QUEUE,
                new User("Giacomo", "Chiavolotti", 42)
        );
    }
}
