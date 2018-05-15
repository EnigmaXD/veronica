package com.veronica.mongo.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.veronica.mongo.dao.BaseDao;
import com.veronica.mongo.model.BaseModel;

public class BaseDaoImpl<T extends BaseModel> implements BaseDao<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Class<T> entityClass;

    public BaseDaoImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

    }

    public void insert(T pojo) {
        mongoTemplate.insert(pojo);
    }

    public void update(T pojo) {
        mongoTemplate.save(pojo);
    }

    public T findById(String id) {
        return mongoTemplate.findById(id, entityClass);
    }
}
