package com.example.springboot.mapper;

import com.example.springboot.entity.SpuSaleValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpuSaleValueMapper {
    int updateSpuSaleVale(SpuSaleValue c);

    @Insert("insert into spusalevaluelist(spuId,baseSaleAttrId,saleAttrValueName,saleAttrName) values (#{spuId},#{baseSaleAttrId},#{saleAttrValueName},#{saleAttrName})")
    int addSpuSaleVale(SpuSaleValue c);
}
