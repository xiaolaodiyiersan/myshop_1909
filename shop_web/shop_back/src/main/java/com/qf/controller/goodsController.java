package com.qf.controller;

import com.qf.entity.Goods;
import com.qf.service.IGoodsService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class goodsController {
    @Reference
    IGoodsService iGoodsService;

    @RequestMapping("/list")
    public String goodsList(Model model ){
        List<Goods> list = iGoodsService.goodsList();
        model.addAttribute("list",list);
        return "goodslist";
    }






   /* @RequestMapping("/ajax")
    @ResponseBody
    public ResultData ajax(){

return new ResultData().setCode(ResultData.ResultCodeList.OK).setData("MyData");
    }*/
}
