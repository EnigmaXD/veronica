package com.veronica.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.veronica.mongo.dao.BaseDao;
import com.veronica.mongo.model.BaseModel;

public class BaseDaoImpl implements BaseDao {

    @Autowired
    protected MongoTemplate mongoOperations;

    public <T extends BaseModel> void insert(T pojo) {
        mongoOperations.insert(pojo);
    }
}
