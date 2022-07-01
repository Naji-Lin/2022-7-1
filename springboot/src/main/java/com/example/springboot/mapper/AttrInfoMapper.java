package com.example.springboot.mapper;


import com.example.springboot.entity.AttrInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttrInfoMapper {

    List<AttrInfo> attrInfoList(@Param("categoryId")int categoryId);

    @Insert("INSERT INTO attrinfolist(attrName,categoryId,categoryLevel) VALUES (#{attrName},#{categoryId},#{categoryLevel}) ")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int attrInfoInsert(AttrInfo attrInfo);

    int attrInfoUpdate(AttrInfo attrInfo);
}
