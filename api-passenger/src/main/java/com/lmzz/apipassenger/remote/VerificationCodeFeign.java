package com.lmzz.apipassenger.remote;

import com.lmzz.dto.ResponseResult;
import com.lmzz.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-verificationcode")
public interface VerificationCodeFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> numberCode(@PathVariable int size);
}
