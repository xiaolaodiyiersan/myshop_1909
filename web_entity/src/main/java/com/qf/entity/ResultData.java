package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultData<T> {
private String code;//错误码
    private String msg;//错误信息
    private T data;//数据部分

    public static interface ResultCodeList{
        String ERROR = "500";
        String OK = "200";
    }
}
