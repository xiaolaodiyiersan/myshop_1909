package com.qf.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GoodMapper;
import com.qf.dao.GoodsImageMapper;
import com.qf.entity.Goods;
import com.qf.entity.GoodsImages;
import com.qf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class IGoodeServiceImpl implements IGoodsService {
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    GoodsImageMapper goodsImageMapper;
    @Override
    public List<Goods> goodsList() {
        return goodMapper.Goodslist();
    }

    @Override
    @Transactional
    public void insertGoods(Goods goods) {
        goodMapper.insert(goods);
        GoodsImages goodsImages = new GoodsImages().setGid(goods.getId()).setUrl(goods.getFmurl()).setIsfengmian(1);
        goodsImageMapper.insert(goodsImages);
        for (String g:goods.getOthersurl()
             ) {
            System.out.println(g);
            GoodsImages goodsImages1 = new GoodsImages().setGid(goods.getId()).setUrl(g).setIsfengmian(0);
            goodsImageMapper.insert(goodsImages1);
        }
    }
}
