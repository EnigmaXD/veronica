package com.veronica.mongo.dao;

import com.veronica.mongo.model.BaseModel;

public interface BaseDao<T extends BaseModel> {

    public void insert(T pojo);

    public void update(T pojo);

    public T findById(String id);

}
