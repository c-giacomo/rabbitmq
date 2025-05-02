package com.rabbitmq.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.model.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitMQConfiguration {

    public static final String TEST_QUEUE = "test.queue";

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter(new ObjectMapper().registerModule(new JavaTimeModule()));
        converter.setClassMapper(classMapper());
        return rabbitTemplate;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper mapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("String", String.class);
        idClassMapping.put("User", User.class);
        mapper.setIdClassMapping(idClassMapping);
        return mapper;
    }


    @Bean
    public Queue queue() {
        return new Queue(TEST_QUEUE, true);
    }

}
