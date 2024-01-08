package com.memory.client.model;

import lombok.Data;

/**
 * @author 邓哈哈
 * 2023/11/19 22:37
 * Function: 图片类
 * Version 1.0
 */

@Data
public class Picture {
    public Picture() {
    }

    public Picture(String category) {
        this.category = category;
    }

    /**
     * 所属分类
     */
    private String category;
}
