package com.example.springboot.mapper;

import com.example.springboot.entity.Goods;
import com.example.springboot.entity.TradeMark;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyListMapper {
    List<Goods> getGoodsList(int category3Id, String categoryName, String keyword, String trademark, int pageNum, int pageSize);

    @Select("select * from base_trademark ORDER BY tmId DESC")
    List<TradeMark> getTradeMark();

    int selectAll(int c3Id, String categoryName, String keyword, String trademark);
}
