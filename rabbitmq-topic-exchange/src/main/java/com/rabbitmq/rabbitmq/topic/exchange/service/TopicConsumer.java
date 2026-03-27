package com.rabbitmq.rabbitmq.topic.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicConsumer {

    @RabbitListener(queues = "queue.rischio")
    public void receiveRischio(String msg) {
        log.info("RISCHIO: {}", msg);
    }

    @RabbitListener(queues = "queue.alert")
    public void receiveAlert(String msg) {
        log.info("ALERT: {}", msg);
    }

}
