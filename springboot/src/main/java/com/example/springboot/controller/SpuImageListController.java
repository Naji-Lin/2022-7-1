package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.SpuImageList;
import com.example.springboot.mapper.SpuImageListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpuImageListController {
    @Autowired
    private SpuImageListMapper spuImageListMapper;

    @GetMapping("/admin/product/spuImageList/{spuId}")
    public Result selectSpuList(@PathVariable int spuId){
        List<SpuImageList> res = spuImageListMapper.findAll(spuId);
        return Result.success(res);
    }
}
