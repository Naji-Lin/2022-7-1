package com.example.springboot.mapper;

import com.example.springboot.entity.SkuAttrValue;
import com.example.springboot.entity.SkuImageList;
import com.example.springboot.entity.SkuList;
import com.example.springboot.entity.SkuSaleAttr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SkuListMapper {
    @Insert("insert into skulist(spuId,price,skuName,skuDesc,weight,tmId,category3Id,skuDefaultImg) values (#{spuId},#{price},#{skuName},#{skuDesc},#{weight},#{tmId},#{category3Id},#{skuDefaultImg})")
    int saveSkuInfo(SkuList skuList);

    @Select("select * from skulist where spuId = #{spuId}")
    List<SkuList> selectById(int spuId);

    @Select("SELECT * FROM skulist LIMIT #{pageNum},#{limit}")
    List<SkuList> findPage(int pageNum, int limit);

    @Select("select count(*) from skulist")
    int selectTotal();

    List<SkuList> getSkuById(int skuId);

    @Update("update skulist set isSale = 1 where id = #{skuId}")
    int onSale(int skuId);

    @Update("update skulist set isSale = 0 where id = #{skuId}")
    int cancelSale(int skuId);

    @Insert("insert into skuimagelist(skuId,imgName,imgUrl,spuImgId,isDefault) values (#{skuId},#{imgName},#{imgUrl},#{spuImgId},#{isDefault})")
    void saveSkuImageList(SkuImageList a);

    @Insert("insert into skusaleattrvaluelist(skuId,spuId,saleAttrValueId,saleAttrId,saleAttrName,saleAttrValueName) values (#{skuId},#{spuId},#{saleAttrValueId},#{saleAttrId},#{saleAttrName},#{saleAttrValueName})")
    int saveSkuSaleAttr(SkuSaleAttr b);

    @Insert("insert into skuattrvaluelist(attrId,valueId,attrName,valueName) values (#{attrId},#{valueId},#{attrName},#{valueName})")
    int saveAttrValue(SkuAttrValue c);
}
