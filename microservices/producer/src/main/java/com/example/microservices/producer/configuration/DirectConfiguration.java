package com.example.microservices.producer.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

    public static final String DIRECT_EXCHANGE = "direct.exchange"; // NOME EXCHANGE
    public static final String QUEUE = "queue";
    public static final String ROUTING = "routing";

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(DIRECT_EXCHANGE);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(new ObjectMapper().registerModule(new JavaTimeModule())));
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queueA, DirectExchange exchange) {
        return BindingBuilder
                .bind(queueA)
                .to(exchange)
                .with(ROUTING);
    }
}
