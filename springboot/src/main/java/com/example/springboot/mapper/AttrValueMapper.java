package com.example.springboot.mapper;

import com.example.springboot.entity.AttrValue;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AttrValueMapper {

    @Insert("insert into attrvaluelist(attrId,valueName) values (#{attrId},#{valueName})")
    int attrValueInsert(AttrValue a);

    int attrValueUpdate(AttrValue a);
}
