package com.rabbitmq.rabbitmq.topic.exchange.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQTopicConfiguration {

    public static final String TOPIC_EXCHANGE = "eventi.topic";

    public static final String QUEUE_MALE = "queue.rischio";
    public static final String QUEUE_FEMALE = "queue.alert";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Queue rischioQueue() {
        return new Queue(QUEUE_MALE);
    }

    @Bean
    Queue alertQueue() {
        return new Queue(QUEUE_FEMALE);
    }

    @Bean
    Binding bindRischio(Queue rischioQueue, TopicExchange exchange) {
        return BindingBuilder.bind(rischioQueue)
                .to(exchange)
                .with("eventi.rischio.*");
    }

    @Bean
    Binding bindAlert(Queue alertQueue, TopicExchange exchange) {
        return BindingBuilder.bind(alertQueue)
                .to(exchange)
                .with("eventi.#");
    }
}
