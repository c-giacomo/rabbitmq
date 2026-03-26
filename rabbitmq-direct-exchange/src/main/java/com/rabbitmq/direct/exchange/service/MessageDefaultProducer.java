package com.rabbitmq.direct.exchange.service;

import com.rabbitmq.direct.exchange.configuration.RabbitDirectExchangeConfiguration;
import com.rabbitmq.direct.exchange.interfaces.IMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
@RequiredArgsConstructor
public class MessageDefaultProducer implements IMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void inviaMessaggio() {
        rabbitTemplate.convertAndSend(
                "",                                     // exchange vuoto -> default
                RabbitDirectExchangeConfiguration.QUEUE_A,       // routing -> nome coda
                "default"                                        // messaggio
        );
    }
}
