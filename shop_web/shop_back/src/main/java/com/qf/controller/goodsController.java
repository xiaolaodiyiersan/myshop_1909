package com.qf.controller;

import com.qf.entity.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class goodsController {
    @RequestMapping("/list")
    public String goodsList(){
        System.out.println(1/0);
        return "goodslist";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public ResultData ajax(){
        System.out.println(1/0);
return new ResultData().setCode(ResultData.ResultCodeList.OK).setData("MyData");
    }
}
