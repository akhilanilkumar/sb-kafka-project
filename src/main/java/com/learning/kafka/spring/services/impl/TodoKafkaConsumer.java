package com.learning.kafka.spring.services.impl;

import com.learning.kafka.spring.model.Todo;
import com.learning.kafka.spring.services.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TodoKafkaConsumer implements Consumer<Todo> {

    @Override
    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public Todo consumeMessage(Todo data) {
        log.info("Received Message: {}", data);
        return data;
    }
}
