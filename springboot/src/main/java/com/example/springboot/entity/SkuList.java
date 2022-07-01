package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "skulist")
public class SkuList {
    @TableId(type = IdType.AUTO)
    private int id;
    private int spuId;
    private int price;
    private String skuName;
    private String skuDesc;
    private String weight;
    private int tmId;
    private int category3Id;
    private String skuDefaultImg;
    private int isSale;
    private String createTime;
    @TableField(exist = false)
    private List<SkuImageList> skuImageList;
    @TableField(exist = false)
    private List<SkuAttrValue> skuAttrValueList;
    @TableField(exist = false)
    private List<SkuSaleAttr> skuSaleAttrValueList;
}
