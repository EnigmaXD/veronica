package com.veronica.mongo.dao;

import com.veronica.mongo.model.BaseModel;

public interface BaseDao {

    public <T extends BaseModel> void insert(T pojo);

    // public void save(BaseModel obj);

}
