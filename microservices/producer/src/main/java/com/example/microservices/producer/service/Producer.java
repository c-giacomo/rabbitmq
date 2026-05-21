package com.example.microservices.producer.service;

import com.example.microservices.producer.configuration.DirectConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public void inviaMessaggio() {
        rabbitTemplate.convertAndSend(
                DirectConfiguration.DIRECT_EXCHANGE,      // nome exchange
                DirectConfiguration.ROUTING,             // routing
                "ficale"                                               // messaggio
        );
    }
}
