package com.learning.kafka.spring.services;

public interface Consumer<T> {

    T consumeMessage(T data);
}
