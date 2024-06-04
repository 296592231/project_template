package com.jl.core.base.enums;

/**
 * 异常错误枚举接口
 * Created by kz on 2018/3/8.
 */
public interface BaseErrorEnum {

    /**
     * 获取错误码
     * @return 错误码
     */
    String getCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMessage();

}
