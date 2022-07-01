package com.example.springboot.controller;


import com.example.springboot.common.Result;
import com.example.springboot.entity.Category1;
import com.example.springboot.mapper.Category1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Category1Controller {
    @Autowired
    private Category1Mapper category1Mapper;
    //查询所有
    @GetMapping("/admin/product/getCategory1")
    public Result all(){
        List<Category1> allMarks = category1Mapper.findAll();
        return Result.success(allMarks);
    }
}
