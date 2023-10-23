package ru.sfu.nivanova.lab7boot.msg_producer;

import lombok.Data;

@Data
public class Message {
    private String message;
    private String routingKey;
}
