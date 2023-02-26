package com.ravage.apachekafka.infrastructure;

import com.ravage.apachekafka.kafka.NotificationProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class ReminderController {

    private NotificationProducer kafkaProducer;

    public ReminderController(NotificationProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/reminder")
    public ResponseEntity<String> publish(@RequestBody Reminder reminderMessage){
        kafkaProducer.sendMessage(reminderMessage);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}