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
@TableName(value = "spusaleattrlist")
public class SpuSaleAttr {
    @TableId(type = IdType.AUTO)
    private int id;
    private int spuId;
    private int baseSaleAttrId;
    private String saleAttrName;
    @TableField(exist = false)
    private List<SpuSaleValue> spuSaleAttrValueList;

}
