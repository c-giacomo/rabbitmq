package com.rabbitmq.direct.exchange.service;

import com.rabbitmq.direct.exchange.configuration.RabbitDirectExchangeConfiguration;
import com.rabbitmq.direct.exchange.interfaces.IMessageProducer;
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
                RabbitDirectExchangeConfiguration.DIRECT_EXCHANGE,      // nome exchange
                RabbitDirectExchangeConfiguration.ROUTINGA,             // routing
                "ficaleA"                                               // messaggio
        );

        rabbitTemplate.convertAndSend(
                RabbitDirectExchangeConfiguration.DIRECT_EXCHANGE,      // nome exchange
                RabbitDirectExchangeConfiguration.ROUTINGB,             // routing
                "ficaleB"                                               // messaggio
        );
    }
}
