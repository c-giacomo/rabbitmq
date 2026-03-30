package com.rabbitmq.fanout.exchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FanoutProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        rabbitTemplate.convertAndSend(
                "my.fanout.exchange",
                "",         // ignorata nel fanout
                "MESSAGE"
        );
    }

}
