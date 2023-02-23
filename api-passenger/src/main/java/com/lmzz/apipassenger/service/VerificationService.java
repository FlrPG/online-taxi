package com.lmzz.apipassenger.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {
    public String generateCode(String phone) {
        System.out.println("调用验证码服务，获取验证码");
        String code = "123456";
        //存储redis

        //
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", code);
        return result.toString();
    }
}
