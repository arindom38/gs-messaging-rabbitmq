package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "spring-boot")
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1000);

	public void receiveMessage(String message) {
		try {
			System.out.println(Thread.currentThread()+"  Received <" + message + ">");
			Thread.sleep(2000);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
