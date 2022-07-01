package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "skusaleattrvaluelist")
public class SkuSaleAttr {
    @TableId(type = IdType.AUTO)
    private int id;
    private int skuId;
    private int spuId;
    private int saleAttrValueId;
    private int saleAttrId;
    private String saleAttrName;
    private String saleAttrValueName;
}
