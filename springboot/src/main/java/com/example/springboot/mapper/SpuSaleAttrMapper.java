package com.example.springboot.mapper;

import com.example.springboot.entity.SpuSaleAttr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SpuSaleAttrMapper {
    int updateSpuSaleAttrList(SpuSaleAttr b);

    @Insert("insert into spusaleattrlist(spuId,baseSaleAttrId,saleAttrName) values (#{spuId},#{baseSaleAttrId},#{saleAttrName})")
    int addSpuSaleAttrList(SpuSaleAttr b);

    List<SpuSaleAttr> selectSpuSaleAttrList(int spuId);
}
