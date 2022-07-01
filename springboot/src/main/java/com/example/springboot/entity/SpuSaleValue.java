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
@TableName(value = "spusalevaluelist")
public class SpuSaleValue {
    @TableId(type = IdType.AUTO)
    private int id;
    private int spuId;
    private int baseSaleAttrId;
    private String saleAttrValueName;
    private String saleAttrName;
    private String isChecked;
}
