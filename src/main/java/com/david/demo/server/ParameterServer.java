package com.david.demo.server;

import com.david.demo.database.repositoty.IParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统参数业务逻辑
 *
 * @2018-11-28
 * @David
 */
@Service
public class ParameterServer {
    @Autowired
    private IParameterRepository parameterRepository;
}
