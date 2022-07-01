package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Category2;
import com.example.springboot.mapper.Category2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Category2Controller {
    @Autowired
    private Category2Mapper category2Mapper;
    @GetMapping("/admin/product/getCategory2/{category1Id}")
    public Result selectAll(@PathVariable int category1Id){
        List<Category2> data = category2Mapper.selectAll(category1Id);
        return Result.success(data);
    }
}
