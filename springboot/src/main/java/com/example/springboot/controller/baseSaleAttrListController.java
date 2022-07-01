package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.mapper.baseSaleAttrListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class baseSaleAttrListController {
    @Autowired
    private baseSaleAttrListMapper b;

    @GetMapping("/admin/product/baseSaleAttrList")
    public Result findAll(){
        return Result.success(b.findAll());
    }
}
