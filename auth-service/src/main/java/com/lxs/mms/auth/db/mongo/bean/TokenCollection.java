package com.lxs.mms.auth.db.mongo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 对应MongoDB中的Token集合。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Document(collection = "Token")
@Data
public class TokenCollection {
    @Id
    public String _id;

    @Indexed
    public String token;
    private String id;

    private Date updateDate;
}
