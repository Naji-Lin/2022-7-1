package com.example.springboot.mapper;

import com.example.springboot.entity.Category1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Category1Mapper {
    @Select("SELECT * from category1")
    List<Category1> findAll();
}
