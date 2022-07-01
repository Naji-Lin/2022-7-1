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
@TableName(value = "spuimagelist")
public class SpuImageList {
    @TableId(type = IdType.AUTO)
    private int id;
    private int spuId;
    private String imgName;
    private String imgUrl;
}
