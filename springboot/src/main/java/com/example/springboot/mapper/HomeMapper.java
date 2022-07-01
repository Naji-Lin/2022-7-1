package com.example.springboot.mapper;

import com.example.springboot.entity.BaseCategoryList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<BaseCategoryList> getBaseCategoryList();

}
