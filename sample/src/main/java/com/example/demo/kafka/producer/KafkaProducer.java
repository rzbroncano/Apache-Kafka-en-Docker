package com.example.demo.kafka.producer;

public interface KafkaProducer {

    void sendMessage(String topicName, String message);

    void sendMessageWithListenable(String topicName, String message);
}
