package com.concurrent.config;

import com.concurrent.model.Countable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CascadeCallback implements ReflectionUtils.FieldCallback {
    private Object source;
    private MongoOperations mongoOperations;
    private AtomicLong atomicLong = new AtomicLong();

    CascadeCallback(final Object source, final MongoOperations mongoOperations) {
        this.source = source;
        this.setMongoOperations(mongoOperations);
    }

    @Override
    public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
        atomicLong.set(0);
        ReflectionUtils.makeAccessible(field);
        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
            final Object fieldValue = field.get(getSource());
            if (fieldValue != null) {
                final FieldCallBack callback = new FieldCallBack();
                ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
                if (fieldValue instanceof Collection) {
                    List list = new ArrayList((Collection) fieldValue);
                    list.forEach(e -> {
                        if (e instanceof Countable) {
                            ((Countable) e).countId((Long) atomicLong.getAndIncrement());
                        }
                        getMongoOperations().save(e);
                    });
                } else {
                    getMongoOperations().save(fieldValue);
                }
            }
        }
    }

    private Object getSource() {
        return source;
    }

    public void setSource(final Object source) {
        this.source = source;
    }

    private MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    private void setMongoOperations(final MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}
