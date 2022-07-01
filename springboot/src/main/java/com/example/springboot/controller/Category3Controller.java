package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Category3;
import com.example.springboot.mapper.Category3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Category3Controller {
    @Autowired
    private Category3Mapper category3Mapper;
    @GetMapping("/admin/product/getCategory3/{category2Id}")
    public Result selectCategory3(@PathVariable int category2Id){
        List<Category3> data = category3Mapper.selectCategory3(category2Id);
        return Result.success(data);
    }
}
