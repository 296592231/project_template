package com.jl.core.base.vo.response;

import com.jl.core.base.enums.BaseEnum;
import com.jl.core.base.enums.BaseErrorEnum;
import com.jl.core.base.exception.BaseException;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jl
 * @date 2024/6/4 11:46
 */
@Data
public class BaseResponseVO<T> implements Serializable {

    private static final long serialVersionUID = 730896939262757984L;

    /** 响应码 **/
    private String respCode;

    /** 响应描述 **/
    private String respMsg;

    /** 响应数据 **/
    private String respData;

    /**
     *  默认构造方法，默认返回成功
     * Created by kz on 2018/11/1 14:49.
     */
    public BaseResponseVO(){
        this.respCode = BaseEnum.SUCCESS.getCode();
        this.respMsg = BaseEnum.SUCCESS.getMessage();
    }

    /**
     *  默认构造方法，默认返回成功
     *  @param code 错误码
     *  @param message 错误信息
     * Created by kz on 2018/11/1 14:49.
     */
    public BaseResponseVO(String code , String message){
        this.respCode = code;
        this.respMsg = message;
    }

    /**
     * 业务异常
     * Created by kz on 2018/11/1 14:49.
     */
    public BaseResponseVO(BaseException e){
        this.respCode = e.getCode();
        this.respMsg = e.getMessage();
    }

    /**
     * 错误码
     * Created by kz on 2018/11/1 14:49.
     */
    public BaseResponseVO(BaseErrorEnum errorEnum){
        this.respCode = errorEnum.getCode();
        this.respMsg = errorEnum.getMessage();
    }
}
