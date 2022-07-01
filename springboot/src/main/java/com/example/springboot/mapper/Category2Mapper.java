package com.example.springboot.mapper;

import com.example.springboot.entity.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Category2Mapper {
    @Select("SELECT * from category2 where category1Id = #{category1Id}")
    List<Category2> selectAll(@Param("category1Id")int category1Id);
}
