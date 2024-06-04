package com.jl.core.base.exception;

import com.jl.core.base.enums.BaseErrorEnum;
import lombok.Getter;

/**
 * 基础业务异常
 * Created by jl on 2024/6/4 11:58
 */
@Getter
public class BaseException extends RuntimeException {

    /** 序列化ID */
    private static final long serialVersionUID = -9177074358208860222L;

    /** 错误码 */
    private final String code;

    /** 错误信息 */
    private final String mesg;

    /**
     * 构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.mesg = message;
    }

    /**
     * 构造函数
     * @param message 错误信息
     * @param throwable 异常对象
     */
    public BaseException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.mesg = message;
    }

    /**
     * 构造函数
     * @param errorEnum 错误枚举
     */
    public BaseException(BaseErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
        this.mesg = errorEnum.getMessage();
    }

    /**
     * 构造函数
     * @param errorEnum 错误枚举
     * @param throwable 异常对象
     */
    public BaseException(BaseErrorEnum errorEnum, Throwable throwable) {
        super(errorEnum.getMessage(), throwable);
        this.code = errorEnum.getCode();
        this.mesg = errorEnum.getMessage();
    }

}
