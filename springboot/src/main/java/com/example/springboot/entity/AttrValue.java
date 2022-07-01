package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "attrvaluelist")
public class AttrValue {
    private int id;
    private String valueName;
    private int attrId;
}
