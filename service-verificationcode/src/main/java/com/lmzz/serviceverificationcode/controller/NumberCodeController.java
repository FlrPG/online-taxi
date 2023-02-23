package com.lmzz.serviceverificationcode.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public String numberCode(@PathVariable Integer size) {
        System.out.println("size:" + size);

        int code = (int) ((Math.random() * 9 + 1) * Math.pow(10, size - 1));

        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "test");
        JSONObject data = new JSONObject();
        data.put("numberCode", code);
        result.put("data", data);
        return result.toString();
    }


}
