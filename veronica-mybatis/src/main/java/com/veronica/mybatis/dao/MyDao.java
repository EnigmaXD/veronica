package com.veronica.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.veronica.mybatis.lang.SimpleSelectLangDriver;
import com.veronica.mybatis.model.MyModel;

@Mapper
public interface MyDao extends BaseDao<MyModel> {

    @Lang(SimpleSelectLangDriver.class)
    @Select("SELECT * FROM (#{from}) (#{where})")
    @Override
    public List<MyModel> selectByParams(@Param("pojo") MyModel pojo);
}
