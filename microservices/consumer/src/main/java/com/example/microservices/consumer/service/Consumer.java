package com.example.microservices.consumer.service;

import com.example.microservices.consumer.configuration.DirectConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @RabbitListener(queues = DirectConfiguration.QUEUE)
    public void riceviMessaggioA(String messaggio) {
        log.info("Messaggio scannato: {}", messaggio);
    }
}
