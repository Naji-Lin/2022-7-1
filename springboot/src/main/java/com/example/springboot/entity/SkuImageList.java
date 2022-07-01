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
@TableName(value = "skuimagelist")
public class SkuImageList {
    @TableId(type = IdType.AUTO)
    private int id;
    private int skuId;
    private String imgName;
    private String imgUrl;
    private int spuImgId;
    private String isDefault;
}
