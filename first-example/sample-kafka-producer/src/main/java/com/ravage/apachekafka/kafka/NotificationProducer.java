package com.ravage.apachekafka.kafka;

import com.ravage.apachekafka.infrastructure.Reminder;

public interface NotificationProducer {

    void sendMessage(Reminder welcomeRequest);

    void sendMessageWithListenable(String topicName, String message);
}
