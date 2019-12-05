package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Goods;
import com.qf.entity.ResultData;
import com.qf.service.IGoodsService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class goodsController {
     public static String path = "E:/image";
    @Reference
    IGoodsService iGoodsService;

    @RequestMapping("/list")
    public String goodsList(Model model ){
        List<Goods> list = iGoodsService.goodsList();
        for (Goods goods:
             list) {
            System.out.println(goods);
        }
        model.addAttribute("list",list);
        return "goodslist";
    }

@RequestMapping("/uploader")
    @ResponseBody
  public ResultData<String> uploader(MultipartFile file){
    System.out.println("上传图片名："+ file.getOriginalFilename());
String filename = UUID.randomUUID().toString().replaceAll("-","");
String Uploaderpath = path+"/"+filename;
try(InputStream in = file.getInputStream();
        OutputStream out = new FileOutputStream(Uploaderpath)
        ){
    IOUtils.copy(in,out);
    } catch (IOException e) {
    e.printStackTrace();
}
return  new ResultData<String>().setCode(ResultData.ResultCodeList.OK).setData(Uploaderpath);
    }

@RequestMapping("/show")
    public void show(HttpServletResponse response,String imgPath){
try (
        InputStream in = new FileInputStream(imgPath);
        ServletOutputStream out = response.getOutputStream();
        ){
    IOUtils.copy(in,out);
}catch (Exception e){

}
}

@RequestMapping("insert")
    public String insert(Goods goods) {
        iGoodsService.insertGoods(goods);
    return "redirect:/goods/list";
}



   /* @RequestMapping("/ajax")
    @ResponseBody
    public ResultData ajax(){

return new ResultData().setCode(ResultData.ResultCodeList.OK).setData("MyData");
    }*/
}
