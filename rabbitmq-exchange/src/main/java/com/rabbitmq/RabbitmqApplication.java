package com.rabbitmq;

import com.rabbitmq.interfaces.IMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitmqApplication implements CommandLineRunner {

	private final IMessageProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.inviaMessaggio();
	}
}
