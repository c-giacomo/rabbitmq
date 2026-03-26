package com.rabbitmq.service;

import com.rabbitmq.configuration.RabbitMQConfiguration;
import com.rabbitmq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfiguration.TEST_QUEUE)
    public void riceviMessaggio(String messaggio) {
        if (messaggio instanceof String mess) {
            log.info("Messaggio ricevuto: {}", mess);
        }
    }

    @RabbitListener(queues = RabbitMQConfiguration.TEST_QUEUE)
    public void riceviMessaggio(User user) {
        if (user != null) {
            log.info("Utente nome: {}, cognome: {}, età {}", user.getName(), user.getSurname(), user.getAge());
        }
    }

}
