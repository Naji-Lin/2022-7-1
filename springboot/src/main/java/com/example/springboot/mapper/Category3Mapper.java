package com.example.springboot.mapper;

import com.example.springboot.entity.Category3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Category3Mapper {
    @Select("SELECT * from category3 where category2Id = #{category2Id}")
    List<Category3> selectCategory3(@Param("category2Id")int category2Id);
}
