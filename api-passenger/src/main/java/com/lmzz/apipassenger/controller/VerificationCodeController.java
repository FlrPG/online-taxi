package com.lmzz.apipassenger.controller;

import com.lmzz.apipassenger.request.VerificationCodeDTO;
import com.lmzz.apipassenger.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {
    @Autowired
    VerificationService verificationService;

    @GetMapping("/verificationCode")
    public String verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        System.out.println("接收的手机号：" + verificationCodeDTO.getPassengerPhone());
        String s = verificationService.generateCode(verificationCodeDTO.getPassengerPhone());
        return "string";
    }
}
