package com.learning.kafka.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {
    private Long id;

    private Long userId;

    private String title;

    private boolean completed;
}

