package com.rabbitmq.direct.exchange.service;

import com.rabbitmq.direct.exchange.configuration.RabbitDirectExchangeConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    // DIRECT EXCHANGE LISTENER
    @RabbitListener(queues = RabbitDirectExchangeConfiguration.QUEUE_A)
    public void riceviMessaggioA(String messaggio) {
        log.info("Messaggio scannato: {}", messaggio);
    }

    // DIRECT EXCHANGE LISTENER
    @RabbitListener(queues = RabbitDirectExchangeConfiguration.QUEUE_B)
    public void riceviMessaggioB(String messaggio) {
        log.info("Messaggio ricevuto: {}", messaggio);
    }
}
