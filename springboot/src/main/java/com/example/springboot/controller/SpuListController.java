package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.*;
import com.example.springboot.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SpuListController {

    @Autowired
    private SpuListMapper spuListMapper;

    @Autowired
    private TradeMarkMapper tradeMarkMapper;

    @Autowired
    private SpuImageListMapper spuImageListMapper;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    private SpuSaleValueMapper spuSaleValueMapper;

    @GetMapping("/admin/product/getSpuById/{spuId}")
    public Result selectSpuList(@PathVariable int spuId){
        List<SpuList> res = spuListMapper.spuList(spuId);
        return Result.success(res);
    }
    //分页
    @GetMapping("/admin/product/{page}/{limit}")
    public Result findPage(@PathVariable int page, @PathVariable int limit, @RequestParam int category3Id){
        int pageNum = (page -1) * limit;
        List<SpuList> data = spuListMapper.findPage(pageNum,limit,category3Id);
        int total = spuListMapper.selectTotal();
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
    @GetMapping("/admin/product/baseTrademark/getTrademarkList")
    public Result tradeMarkGet(){
        List<TradeMark> allMarks = tradeMarkMapper.findAll();
        return Result.success(allMarks);
    }
    //更新
    @PostMapping("/admin/product/updateSpuInfo")
    public Result updateSpuList(@RequestBody SpuList spuList){
        spuListMapper.updateSpuList(spuList);
        if(spuList.getSpuImageList()!=null && !spuList.getSpuImageList().isEmpty()){
            for (SpuImageList a : spuList.getSpuImageList()){
                if("0".equals(String.valueOf(a.getId())) || "null".equals(String.valueOf(a.getId())) || a.getId() <= 0){
                    a.setSpuId(spuList.getId());
                    spuImageListMapper.addSpuImageList(a);
                }else{
                    spuImageListMapper.updateSpuImageList(a);
                }
            }
        }
        if(spuList.getSpuSaleAttrList()!=null && !spuList.getSpuSaleAttrList().isEmpty()){
            for (SpuSaleAttr b :spuList.getSpuSaleAttrList()){
                b.setSpuId(spuList.getId());
                if("0".equals(String.valueOf(b.getId())) || "null".equals(String.valueOf(b.getId())) || b.getId() <= 0){
                    spuSaleAttrMapper.addSpuSaleAttrList(b);
                }else{
                    spuSaleAttrMapper.updateSpuSaleAttrList(b);
                }
                for (SpuSaleValue c : b.getSpuSaleAttrValueList()){
                    c.setSpuId(spuList.getId());
                    c.setSaleAttrName(b.getSaleAttrName());
                    if("0".equals(String.valueOf(c.getId())) || "null".equals(String.valueOf(c.getId())) || c.getId() <= 0){
                        spuSaleValueMapper.addSpuSaleVale(c);
                    }else{
                        spuSaleValueMapper.updateSpuSaleVale(c);
                    }
                }
            }
        }
        return Result.success();
    }

    //添加
    @PostMapping("/admin/product/saveSpuInfo")
    public Result addSpuList(@RequestBody SpuList spuList){
        spuListMapper.addSpuList(spuList);
        int newIndex = spuList.getId();
        if(spuList.getSpuImageList()!=null && !spuList.getSpuImageList().isEmpty()){
            for(SpuImageList a : spuList.getSpuImageList()){
                a.setSpuId(newIndex);
                spuImageListMapper.addSpuImageList(a);
            }
        }
        if(spuList.getSpuSaleAttrList()!=null && !spuList.getSpuSaleAttrList().isEmpty()){
            for(SpuSaleAttr b : spuList.getSpuSaleAttrList()){
                b.setSpuId(newIndex);
                spuSaleAttrMapper.addSpuSaleAttrList(b);
                if(b.getSpuSaleAttrValueList()!=null && !b.getSpuSaleAttrValueList().isEmpty()){
                    for (SpuSaleValue c :b.getSpuSaleAttrValueList()){
                        c.setSpuId(newIndex);
                        c.setSaleAttrName(b.getSaleAttrName());
                        spuSaleValueMapper.addSpuSaleVale(c);
                    }
                }
            }
        }
        return Result.success();
    }
    //删除
    @DeleteMapping("/admin/product/deleteSpu/{spuId}")
    public Result deleteSpuList(@PathVariable int spuId){
        spuListMapper.deleteSpuList(spuId);
        return Result.success();
    }
}
