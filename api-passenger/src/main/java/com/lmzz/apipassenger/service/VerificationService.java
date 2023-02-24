package com.lmzz.apipassenger.service;

import com.lmzz.apipassenger.remote.VerificationCodeFeign;
import com.lmzz.constant.ConmonStatusEnum;
import com.lmzz.dto.ResponseResult;
import com.lmzz.response.NumberCodeResponse;
import com.lmzz.response.TokenResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationService {

    @Autowired
    private VerificationCodeFeign verificationCodeFeign;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private String verificationCode = "VerificationCode_";


    public ResponseResult<?> generateCode(String passengerPhone) {
        //获取验证码
        ResponseResult<NumberCodeResponse> responseResult = verificationCodeFeign.numberCode(6);
        int numberCode = responseResult.getData().getNumberCode();

        //存入redis
        redisTemplate.opsForValue().set(generateCodeKey(passengerPhone), numberCode + "", 5, TimeUnit.MINUTES);

        //发送验证码 TD

        //返回
        return ResponseResult.sucess();
    }


    private String generateCodeKey(String passengerPhone) {
        return verificationCode + passengerPhone;
    }

    public ResponseResult<?> verificationCodeCheck(String passengerPhone, String verificationCode) {
        //获取验证码
        String numberCode = redisTemplate.opsForValue().get(generateCodeKey(passengerPhone));
        System.out.println("redis 验证码：" + numberCode);
        //校验验证码
        if (StringUtils.isEmpty(numberCode) || !verificationCode.trim().equals(numberCode.trim())) {
            return ResponseResult.fail(ConmonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), ConmonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //判断用户是否存在，存在返回token

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");
        return ResponseResult.sucess(tokenResponse);
    }
}
