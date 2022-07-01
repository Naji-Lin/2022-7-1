package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category2")
public class CategoryChild {
    private int categoryId;
    private String categoryName;
    @TableField(exist = false)
    private List<BaseCategoryList> categoryChild;
}
