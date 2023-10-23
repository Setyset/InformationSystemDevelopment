package ru.sfu.nivanova.lab8reciever.audit_consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class MessageConsumerService {
    @RabbitListener(queues = "auditQueue")
    public void processMyQueue(String message) {
        System.out.println(new String(message.getBytes()));
    }
}
