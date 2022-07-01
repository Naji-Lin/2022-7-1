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
@TableName(value = "attrinfolist")
public class AttrInfo {
    @TableId(type = IdType.AUTO)
    private int id;
    private String attrName;
    private int categoryId;
    private int categoryLevel;
    @TableField(exist = false)
    private List<AttrValue> attrValueList;
}
