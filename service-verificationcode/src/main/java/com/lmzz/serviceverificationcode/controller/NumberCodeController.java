package com.lmzz.serviceverificationcode.controller;

import com.lmzz.dto.ResponseResult;
import com.lmzz.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable Integer size) {
        System.out.println("size:" + size);

        int code = (int) ((Math.random() * 9 + 1) * Math.pow(10, size - 1));

        NumberCodeResponse data = new NumberCodeResponse();
        data.setNumberCode(code);
        return ResponseResult.sucess(data);
    }


}
