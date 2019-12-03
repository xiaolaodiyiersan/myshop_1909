package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Goods extends BaseEntity{

    String subject;
    String info;
    BigDecimal price;
    Integer save;
    @TableField(exist = false)
    String fmurl;
    @TableField(exist = false)
    List<String> othersurl;
}
