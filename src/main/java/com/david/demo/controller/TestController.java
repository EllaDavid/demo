package com.david.demo.controller;

import com.david.demo.server.TestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试返回
 */
@RestController
@RequestMapping(value = "/demo")
public class TestController {
    @Autowired
    private TestServer testServer;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        testServer.action();

        return "hi!";
    }
}
