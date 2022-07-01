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
@TableName(value = "skuattrvaluelist")
public class SkuAttrValue {
    @TableId(type = IdType.AUTO)
    private int id;
    private int attrId;
    private int valueId;
    private int skuId;
    private String attrName;
    private String valueName;
}
