package com.qf.service;

import com.qf.entity.Goods;

import java.util.List;

public interface IGoodsService {
    List<Goods> goodsList();

    void insertGoods(Goods goods);
}
