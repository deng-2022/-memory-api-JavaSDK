package com.memory.client.model;

import lombok.Data;
import java.io.Serializable;

/**
 * @TableName words
 */
@Data
public class Words implements Serializable {
    private Integer type;

    private static final long serialVersionUID = 1L;
}