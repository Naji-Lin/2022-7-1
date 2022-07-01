package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.TradeMark;
import com.example.springboot.mapper.TradeMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TradeMarkController {
    @Autowired
    private TradeMarkMapper tradeMarkMapper;

    //查询所有
    @GetMapping("/admin/product/baseTrademark")
    public Result all(){
        List<TradeMark> allMarks = tradeMarkMapper.findAll();
        return Result.success(allMarks);
    }

    //增加
    @PostMapping("/admin/product/baseTrademark/save")
    public Result save(@RequestBody TradeMark tradeMark){
        int a = tradeMarkMapper.insert(tradeMark);
        if(a > 0){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    //修改
    @PutMapping("/admin/product/baseTrademark/update")
    public Result update(@RequestBody TradeMark tradeMark){
        int a = tradeMarkMapper.update(tradeMark);
        if(a > 0){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    //删除
    @DeleteMapping("/admin/product/baseTrademark/remove/{id}")
    public Result delete(@PathVariable int id){
        int a = tradeMarkMapper.deleteById(id);
        if(a > 0){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    //分页查询
    @GetMapping("/admin/product/baseTrademark/{page}/{limit}")
    public Result findPage(@PathVariable int page,@PathVariable int limit){
        int pageNum = (page -1) * limit;
        List<TradeMark> data = tradeMarkMapper.findPage(pageNum,limit);
        int total = tradeMarkMapper.selectTotal();
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
}
