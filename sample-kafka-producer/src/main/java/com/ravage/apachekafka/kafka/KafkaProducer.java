package com.ravage.apachekafka.kafka;

import com.ravage.apachekafka.infrastructure.WelcomeRequest;

public interface KafkaProducer {

    void sendMessage(WelcomeRequest welcomeRequest);

    void sendMessageWithListenable(String topicName, String message);
}
