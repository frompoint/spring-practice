package com.snaildev.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class TestController {
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String json() {
        HashMap<String, Object> responseBody = new HashMap<String, Object>();
        responseBody.put("code", 200);
        responseBody.put("message", "Create success.");
        return JSON.toJSONString(responseBody, SerializerFeature.WriteNonStringValueAsString);
    }
}
