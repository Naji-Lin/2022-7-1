package com.example.springboot.mapper;


import com.baomidou.mybatisplus.annotation.OrderBy;
import com.example.springboot.entity.TradeMark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TradeMarkMapper {

    @Select("SELECT * from base_trademark")
    List<TradeMark> findAll();

    @Insert("INSERT INTO base_trademark(tmName,logoUrl) VALUES (#{tmName},#{logoUrl}) ")
    int insert(TradeMark tradeMark);

    int update(TradeMark tradeMark);

    @Delete("delete from base_trademark where id = #{id}")
    int deleteById(@Param("id") int id);

    @Select("SELECT * FROM base_trademark LIMIT #{pageNum},#{pageSize}")
    List<TradeMark> findPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    @Select("select count(*) from base_trademark")
    int selectTotal();
}
