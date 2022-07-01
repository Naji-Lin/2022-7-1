package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.SkuAttrValue;
import com.example.springboot.entity.SkuImageList;
import com.example.springboot.entity.SkuList;
import com.example.springboot.entity.SkuSaleAttr;
import com.example.springboot.mapper.SkuListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SkuListController {
    @Autowired
    private SkuListMapper skuListMapper;


    @GetMapping("/admin/product/findBySpuId/{spuId}")
    public Result selectById(@PathVariable int spuId){
        List<SkuList> res = skuListMapper.selectById(spuId);
        return Result.success(res);
    }

    //分页
    @GetMapping("/admin/product/list/{page}/{limit}")
    public Result findPage(@PathVariable int page, @PathVariable int limit){
        int pageNum = (page -1) * limit;
        List<SkuList> data = skuListMapper.findPage(pageNum,limit);
        int total = skuListMapper.selectTotal();
        int pages = (int) Math.ceil((double) total / limit);
        Map<String, Object> res = new HashMap<>();
        res.put("records",data);
        res.put("total",total);
        res.put("size",limit);
        res.put("current",page);
        res.put("searchCount",true);
        res.put("pages",pages);
        return Result.success(res);
    }

    @GetMapping("/admin/product/getSkuById/{skuId}")
    public Result getSkuById(@PathVariable int skuId){
        List<SkuList> data = skuListMapper.getSkuById(skuId);
        return Result.success(data);
    }

    @GetMapping("/admin/product/onSale/{skuId}")
    public Result onSale(@PathVariable int skuId){
        skuListMapper.onSale(skuId);
        return Result.success();
    }

    @GetMapping("/admin/product/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable int skuId){
        skuListMapper.cancelSale(skuId);
        return Result.success();
    }
    //添加
    @PostMapping("/admin/product/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuList skuList){
        skuListMapper.saveSkuInfo(skuList);
        for (SkuImageList a:skuList.getSkuImageList()){
            skuListMapper.saveSkuImageList(a);
        }
        for (SkuSaleAttr b : skuList.getSkuSaleAttrValueList()){
            skuListMapper.saveSkuSaleAttr(b);
        }
        for (SkuAttrValue c : skuList.getSkuAttrValueList()){
            if("0".equals(String.valueOf(c.getAttrId())) || "null".equals(String.valueOf(c.getValueId()))) {skuListMapper.saveAttrValue(c);}
        }
        return Result.success();
    }
}
