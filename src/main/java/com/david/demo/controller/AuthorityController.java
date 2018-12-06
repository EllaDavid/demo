package com.david.demo.controller;

import com.david.demo.controller.request.LoginRequest;
import com.david.demo.controller.response.LoginResponse;
import com.david.demo.server.AuthorityServer;
import com.david.demo.server.transmit.AuthorityTransmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限响应及返回
 *
 * @2018-11-29
 * @David
 */
@RestController
@RequestMapping(value = "/authority")
public class AuthorityController {
    @Autowired
    private AuthorityServer authorityServer;

    @RequestMapping(value = "/login")
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        try {
            AuthorityTransmit authorityTransmit = authorityServer.login(loginRequest.getEmpno(),
                    loginRequest.getPassword());

            loginResponse.init(authorityTransmit);
        } catch(Exception e) {
            loginResponse.init(false, e.getMessage());
        }

        return loginResponse;
    }
}
