package com.concurrent.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public abstract class BaseEn {
    @Id
    @GeneratedValue
    private long id;
    private String uid = UUID.randomUUID().toString();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }
}
