package com.learning.kafka.spring.services;

public interface Producer<T> {
    void produceMessage(String key, T data);
}
