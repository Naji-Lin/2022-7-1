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
@TableName(value = "spulist")
public class SpuList {
    @TableId(type = IdType.AUTO)
    private int id;
    private String spuName;
    private String description;
    private int category3Id;
    private int tmId;
    @TableField(exist = false)
    private List<SpuSaleAttr> spuSaleAttrList;
    @TableField(exist = false)
    private List<SpuImageList> spuImageList;
}
