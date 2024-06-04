package com.jl.core.base.enums;

import lombok.Getter;

/**
 * 枚举
 *
 * @author jl
 * @date 2024/6/4 12:13
 */
@Getter
public enum BaseEnum implements BaseErrorEnum{

    SUCCESS("0000", "成功"),
    FAIL("9999", "失败"),
    ;

    private String code;

    private String message;

    BaseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
