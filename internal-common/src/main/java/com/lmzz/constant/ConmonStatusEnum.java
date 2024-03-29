package com.lmzz.constant;

import lombok.Getter;

public enum ConmonStatusEnum {
    VERIFICATION_CODE_ERROR(1099, "验证码不正确"),


    SUCCESS(1, "success"),
    FAIL(0, "fail"),
    ;

    @Getter
    private int code;
    @Getter
    private String value;

    ConmonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
