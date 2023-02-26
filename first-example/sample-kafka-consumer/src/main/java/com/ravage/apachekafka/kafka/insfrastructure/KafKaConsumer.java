package com.ravage.apachekafka.kafka.insfrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = "event-history-a", groupId = "group_id")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
