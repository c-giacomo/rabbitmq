package com.rabbitmq.direct.exchange.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class RabbitDefaultExchangeConfiguration {

    public static final String DEFAULT_EXCHANGE = "default.exchange";    // NOME EXCHANGE
    public static final String QUEUE_A = "queue_a";                      // NOME CODA A

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(new ObjectMapper().registerModule(new JavaTimeModule())));
        return rabbitTemplate;
    }

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(DEFAULT_EXCHANGE);
    }
}
