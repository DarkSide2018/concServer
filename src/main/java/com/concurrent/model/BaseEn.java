package com.concurrent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public abstract class BaseEn {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    private String uid;

    public BaseEn() {
        uid = UUID.randomUUID().toString();
    }

    public String getUid() {
        return uid;
    }
}
