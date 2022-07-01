package com.example.springboot.mapper;

import com.example.springboot.entity.SpuList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpuListMapper {
    List<SpuList> spuList(@Param("spuId")int spuId);

    @Select("select * from spulist where category3Id = #{category3Id} limit #{pageNum}, #{pageSize}")
    List<SpuList> findPage(int pageNum,int pageSize,int category3Id);

    @Select("select count(*) from spulist")
    int selectTotal();

    int updateSpuList(SpuList spuList);

    @Insert("insert into spulist(spuName,description,category3Id,tmId) VALUES (#{spuName},#{description},#{category3Id},#{tmId})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int addSpuList(SpuList spuList);

    int deleteSpuList(int spuId);
}
