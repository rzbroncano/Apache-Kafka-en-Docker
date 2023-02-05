package com.ravage.apachekafka.infrastructure;

import com.ravage.apachekafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publishV1")
    public ResponseEntity<String> publish(@RequestBody  WelcomeRequest welcomeRequest){
        kafkaProducer.sendMessage(welcomeRequest);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
    @GetMapping("/publishV2")
    public ResponseEntity<String> publishv2(@RequestParam("topicName") String topicName, @RequestParam("message") String message){
        kafkaProducer.sendMessageWithListenable(topicName, message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}