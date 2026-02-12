package com.rabbitmq.configuration;

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
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("direct")
public class RabbitDirectExchangeConfiguration {

    public static final String DIRECT_EXCHANGE = "direct.exchange"; // NOME EXCHANGE
    public static final String QUEUE_A = "queue_a";                 // NOME CODA A
    public static final String QUEUE_B = "queue_b";                 // NOME CODA B
    public static final String ROUTING = "routing";                 // NOME ROUTING

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(DIRECT_EXCHANGE);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(new ObjectMapper().registerModule(new JavaTimeModule())));
        return rabbitTemplate;
    }

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding bindingA(Queue queueA, DirectExchange exchange) {
        return BindingBuilder
                .bind(queueA)
                .to(exchange)
                .with(ROUTING);
    }

    @Bean
    public Binding bindingB(Queue queueB, DirectExchange exchange) {
        return BindingBuilder
                .bind(queueB)
                .to(exchange)
                .with(ROUTING);
    }
}
