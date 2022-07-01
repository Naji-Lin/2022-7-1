package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequsetList {
    private String category1Id;
    private String category2Id;
    private String category3Id;
    private String categoryName;
    private String keyword;
    private int pageNo;
    private int pageSize;
    private String trademark;
}
