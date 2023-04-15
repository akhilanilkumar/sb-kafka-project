package com.learning.kafka.spring.controller;

import com.learning.kafka.spring.model.Todo;
import com.learning.kafka.spring.services.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "produce")
@RequiredArgsConstructor
public class ProducerController {

    private final Producer<Todo> producer;

    private final String KAFKA_PRODUCER_KEY = "Todo";

    @PostMapping
    public void produce(@RequestBody Todo todo) {
        this.producer.produceMessage(KAFKA_PRODUCER_KEY, todo);
    }
}
