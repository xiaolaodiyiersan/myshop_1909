package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Goods;

import java.util.List;

public interface GoodMapper extends BaseMapper<Goods> {
    List<Goods> Goodslist();
}
