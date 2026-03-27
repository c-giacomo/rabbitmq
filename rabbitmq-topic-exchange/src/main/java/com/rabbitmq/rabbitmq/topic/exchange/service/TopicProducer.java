package com.rabbitmq.rabbitmq.topic.exchange.service;

import com.rabbitmq.rabbitmq.topic.exchange.configuration.RabbitMQTopicConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send() {
//      ROUTING -> eventi.rischio.alto
//
//      match eventi.rischio.* → queue.rischio
//      match eventi.# → queue.alert
        rabbitTemplate.convertAndSend(
                RabbitMQTopicConfiguration.TOPIC_EXCHANGE,
                "eventi.rischio.alto",
                "RISCHIO ALTO!"
        );

//      ROUTING -> eventi.alert.sistema
//
//      match solo eventi.#
        rabbitTemplate.convertAndSend(
                RabbitMQTopicConfiguration.TOPIC_EXCHANGE,
                "eventi.alert.sistema",
                "ALERT SISTEMA!"
        );

//      ROUTING -> eventi.rischio.basso
//
//      match eventi.rischio.* → queue.rischio
//      match eventi.# → queue.alert
        rabbitTemplate.convertAndSend(
                RabbitMQTopicConfiguration.TOPIC_EXCHANGE,
                "eventi.rischio.basso",
                "RISCHIO BASSO!"
        );
    }
}
