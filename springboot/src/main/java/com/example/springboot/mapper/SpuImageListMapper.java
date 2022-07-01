package com.example.springboot.mapper;

import com.example.springboot.entity.SpuImageList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SpuImageListMapper {
    @Select("select * from spuimagelist where spuId = #{spuId}")
    List<SpuImageList> findAll(int spuId);

    int updateSpuImageList(SpuImageList spuImageList);

    @Insert("insert into spuimagelist(spuId,imgName,imgUrl) VALUES (#{spuId},#{imgName},#{imgUrl})")
    int addSpuImageList(SpuImageList a);
}
