package ru.sfu.nivanova.lab7boot.msg_producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducerServiceImpl implements MessageProducerService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend("lab8", routingKey, message);
    }
}
