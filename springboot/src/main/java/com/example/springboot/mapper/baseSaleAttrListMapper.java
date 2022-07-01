package com.example.springboot.mapper;

import com.example.springboot.entity.baseSaleAttrList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface baseSaleAttrListMapper {
    @Select("select * from basesaleattrlist")
    List<baseSaleAttrList> findAll();
}
