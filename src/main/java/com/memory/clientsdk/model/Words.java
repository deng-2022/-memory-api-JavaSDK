package com.memory.clientsdk.model;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName words
 */
@Data
public class Words implements Serializable {
    private Integer type;

    private static final long serialVersionUID = 1L;
}