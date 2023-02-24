package com.lmzz.dto;

import com.lmzz.constant.ConmonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private int code;
    private String message;

    private T data;

    public static <T> ResponseResult sucess() {
        return new ResponseResult()
                .setCode(ConmonStatusEnum.SUCCESS.getCode())
                .setMessage(ConmonStatusEnum.SUCCESS.getValue());
    }

    public static <T> ResponseResult sucess(T data) {
        return new ResponseResult()
                .setCode(ConmonStatusEnum.SUCCESS.getCode())
                .setMessage(ConmonStatusEnum.SUCCESS.getValue())
                .setData(data);
    }

    public static <T> ResponseResult fail(T data) {
        return new ResponseResult().setData(data);
    }

    public static ResponseResult fail(int code, String message) {
        return new ResponseResult()
                .setCode(code)
                .setMessage(message);
    }

    public static ResponseResult fail(int code, String message, String data) {
        return new ResponseResult()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }

}
