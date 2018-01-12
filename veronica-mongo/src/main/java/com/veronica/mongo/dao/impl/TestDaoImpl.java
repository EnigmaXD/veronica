package com.veronica.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.veronica.mongo.dao.TestDao;

public class TestDaoImpl extends BaseDaoImpl implements TestDao {
    @Autowired
    protected MongoTemplate mongoOperations;

    // @Override
    // public <T extends BaseModel> void insert(T pojo) {
    // mongoOperations.insert(pojo);
    // }

}
