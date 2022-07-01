package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.SpuSaleAttr;
import com.example.springboot.mapper.SpuSaleAttrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpuSaleAttrListController {
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @GetMapping("/admin/product/spuSaleAttrList/{spuId}")
    public Result selectSpuSaleAttrList(@PathVariable int spuId){
        List<SpuSaleAttr> res = spuSaleAttrMapper.selectSpuSaleAttrList(spuId);
        return Result.success(res);
    }
}
