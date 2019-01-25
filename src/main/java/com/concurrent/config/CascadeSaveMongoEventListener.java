package com.concurrent.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.util.ReflectionUtils;

import java.util.concurrent.atomic.AtomicLong;

@Log
public class CascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
    public static AtomicLong atomicLong = new AtomicLong();
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {
        super.onBeforeSave(event);
    }

    @Override
    public void onAfterConvert(AfterConvertEvent<Object> event) {

        super.onAfterConvert(event);
    }

    @Override
    public void onAfterLoad(AfterLoadEvent<Object> event) {

        super.onAfterLoad(event);
    }

    @Override
    public void onApplicationEvent(MongoMappingEvent<?> event) {
        super.onApplicationEvent(event);
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        Class<?> aClass = source.getClass();
        ReflectionUtils.doWithFields(aClass,
                new CascadeCallback(source, mongoOperations));
    }
}
