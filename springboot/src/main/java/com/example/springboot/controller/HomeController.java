package com.example.springboot.controller;

import com.example.springboot.common.Result;

import com.example.springboot.entity.BaseCategoryList;
import com.example.springboot.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private HomeMapper homeMapper;
    @GetMapping("/owner-api/product/getBaseCategoryList")
    public Result getBaseCategoryList(){
        List<BaseCategoryList> res = homeMapper.getBaseCategoryList();
        return Result.success(res);
    }

}
