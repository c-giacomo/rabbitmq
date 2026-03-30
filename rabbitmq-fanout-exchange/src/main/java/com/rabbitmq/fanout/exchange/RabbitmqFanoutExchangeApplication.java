package com.rabbitmq.fanout.exchange;

import com.rabbitmq.fanout.exchange.service.FanoutProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitmqFanoutExchangeApplication implements CommandLineRunner {

    private final FanoutProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqFanoutExchangeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage();
    }
}
