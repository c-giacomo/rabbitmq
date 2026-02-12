package com.rabbitmq.service;

import com.rabbitmq.configuration.RabbitDirectExchangeConfiguration;
import com.rabbitmq.interfaces.IMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("direct")
@RequiredArgsConstructor
public class MessageDirectProducer implements IMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void inviaMessaggio() {
        rabbitTemplate.convertAndSend(
                RabbitDirectExchangeConfiguration.DIRECT_EXCHANGE,
                RabbitDirectExchangeConfiguration.ROUTING,
                "ficale"
        );
    }
}
