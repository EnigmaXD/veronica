package com.veronica.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.veronica.mybatis.lang.SimpleSelectLangDriver;

@Mapper
public interface BaseDao<T> {

    @Select("SELECT * FROM (#{from}) (#{where})")
    @Lang(SimpleSelectLangDriver.class)
    public List<T> selectByParams(@Param("pojo") T pojo);
}
