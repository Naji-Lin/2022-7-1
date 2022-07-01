package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Goods;
import com.example.springboot.entity.RequsetList;
import com.example.springboot.entity.TradeMark;
import com.example.springboot.mapper.MyListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyListController {
    @Autowired
    private MyListMapper myListMapper;

    @PostMapping("/owner-api/list")
    public Result getList(@RequestBody RequsetList requsetList){
        int pageNum = (requsetList.getPageNo()-1)*requsetList.getPageSize();
        String trademark;
        if(requsetList.getTrademark()!=null&&requsetList.getTrademark()!=""){
            String[] trademarkArray = requsetList.getTrademark().split(":");
            trademark = trademarkArray[1];
        }else {
            trademark = requsetList.getTrademark();
        }
        int c3Id = Integer.parseInt(requsetList.getCategory3Id());
        List<Goods> goodsList = myListMapper.getGoodsList(c3Id,requsetList.getCategoryName(),requsetList.getKeyword(),trademark,pageNum,requsetList.getPageSize());
        List<TradeMark> trademarkList = myListMapper.getTradeMark();
        int total = myListMapper.selectAll(c3Id,requsetList.getCategoryName(),requsetList.getKeyword(),trademark);
        int totalPages = (int) Math.ceil((double) total / requsetList.getPageSize());
        Map<String, Object> res = new HashMap<>();
        res.put("goodsList",goodsList);
        res.put("trademarkList",trademarkList);
        res.put("pageNo",requsetList.getPageNo());
        res.put("pageSize",requsetList.getPageSize());
        res.put("total",total);
        res.put("totalPages",totalPages);
        return Result.success(res);
    }
}
