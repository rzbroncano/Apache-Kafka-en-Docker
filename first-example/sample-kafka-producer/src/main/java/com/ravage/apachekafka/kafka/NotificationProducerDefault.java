package com.ravage.apachekafka.kafka;


import com.ravage.apachekafka.infrastructure.Reminder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class NotificationProducerDefault implements NotificationProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProducerDefault.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(Reminder welcomeRequest) {
        LOGGER.info(String.format("Message sent -> %s", welcomeRequest.toString()));
        kafkaTemplate.send("event-history-a",welcomeRequest.toString());
    }

    @Override
    public void sendMessageWithListenable(String topicName, String message) {
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}