package com.lmzz.apipassenger.controller;

import com.lmzz.apipassenger.service.VerificationService;
import com.lmzz.dto.ResponseResult;
import com.lmzz.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationService verificationService;

    @GetMapping("/verification-code")
    public ResponseResult<?> verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        //获取验证码
        return verificationService.generateCode(verificationCodeDTO.getPassengerPhone());
    }

    @PostMapping("/verification-code-check")
    public ResponseResult<?> verificationCodeCheck(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        //校验验证码
        return verificationService.verificationCodeCheck(verificationCodeDTO.getPassengerPhone(),verificationCodeDTO.getVerificationCode());
    }
}
