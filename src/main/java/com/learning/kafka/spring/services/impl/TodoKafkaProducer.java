package com.learning.kafka.spring.services.impl;

import com.learning.kafka.spring.model.Todo;
import com.learning.kafka.spring.services.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TodoKafkaProducer implements Producer<Todo> {

    private final KafkaTemplate<String, Todo> kafkaTemplate;

    private final String kafkaTopicName;

    public TodoKafkaProducer(KafkaTemplate<String, Todo> kafkaTemplate,
                             @Value("${kafka.topic}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopicName = topicName;
    }

    @Override
    public void produceMessage(String key, Todo data) {
        log.info("Produced Message: {}", data);
        Message<Todo> todoMessage = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopicName)
                .build();
        kafkaTemplate.send(todoMessage);
    }
}
