package com.qf.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GoodMapper;
import com.qf.entity.Goods;
import com.qf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class IGoodeServiceImpl implements IGoodsService {
    @Autowired
    GoodMapper goodMapper;
    @Override
    public List<Goods> goodsList() {
        return goodMapper.selectList(null);
    }
}
