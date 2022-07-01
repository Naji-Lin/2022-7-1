package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.AttrInfo;
import com.example.springboot.entity.AttrValue;
import com.example.springboot.mapper.AttrInfoMapper;
import com.example.springboot.mapper.AttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttrInfoController {
    @Autowired
    private AttrValueMapper attrValueMapper;

    @Autowired
    private AttrInfoMapper attrInfoMapper;

    @GetMapping("/admin/product/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result selectAttrInfo(@PathVariable int category1Id, @PathVariable int category2Id, @PathVariable int category3Id){
        List<AttrInfo> res =  attrInfoMapper.attrInfoList(category3Id);
        return Result.success(res);
    }

    //添加
    @PostMapping("/admin/product/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody AttrInfo attrInfo){
        if("0".equals(String.valueOf(attrInfo.getId())) || "null".equals(String.valueOf(attrInfo.getId())) || attrInfo.getId() <= 0){
            //添加
            attrInfoMapper.attrInfoInsert(attrInfo);
            int newIndex = attrInfo.getId();
            if(attrInfo.getAttrValueList()!=null && !attrInfo.getAttrValueList().isEmpty()) {
                for (AttrValue a : attrInfo.getAttrValueList()) {
                    a.setAttrId(newIndex);
                    attrValueMapper.attrValueInsert(a);
                }
            }
        }else {
            //修改
            attrInfoMapper.attrInfoUpdate(attrInfo);
            if(attrInfo.getAttrValueList()!=null && !attrInfo.getAttrValueList().isEmpty()) {
                for (AttrValue a : attrInfo.getAttrValueList()) {
                    if("0".equals(String.valueOf(a.getId())) || "null".equals(String.valueOf(a.getId())) || a.getId() <= 0){
                        a.setAttrId(attrInfo.getId());
                        attrValueMapper.attrValueInsert(a);
                    }else {
                        attrValueMapper.attrValueUpdate(a);
                    }
                }
            }
        }
        return Result.success();
    }

}
