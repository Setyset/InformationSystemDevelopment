package ru.sfu.nivanova.lab7boot.msg_producer;

public interface MessageProducerService {
    void sendMessage(String message, String routingKey);
}
