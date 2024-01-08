package com.memory.client.model;

import lombok.Data;

/**
 * @author 邓哈哈
 * 2023/7/28 22:56
 * Function:
 * Version 1.0
 */

@Data
public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
