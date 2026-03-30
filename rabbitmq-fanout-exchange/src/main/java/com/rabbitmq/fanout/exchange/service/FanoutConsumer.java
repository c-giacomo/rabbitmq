package com.rabbitmq.fanout.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FanoutConsumer {

    @RabbitListener(queues = "queue1")
    public void receive(String message) {
        log.info("Consumer1 received: {}", message);
    }

    @RabbitListener(queues = "queue2")
    public void receive2(String message) {
        log.info("Consumer2 received: {}", message);
    }
}
