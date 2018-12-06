package com.david.demo.server;

import com.david.demo.database.prototype.User;
import com.david.demo.database.repositoty.IUserRepository;
import com.david.demo.exception.MyRuntimeException;
import com.david.demo.server.transmit.AuthorityTransmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限业务逻辑
 *
 * @2018-11-29
 * @David
 */
@Service
public class AuthorityServer {
    @Autowired
    private IUserRepository userRepository;

    /**
     * 用户登录
     * @param empno
     * @param password
     * @return
     */
    public AuthorityTransmit login(String empno, String password) {
        AuthorityTransmit authorityTransmit = new AuthorityTransmit();
        User user = userRepository.findByEmpno(empno);

        if(user == null) {
            throw new MyRuntimeException("AuthorityServer", "数据库查询对象为空");
        }

        if(!password.equals(user.getPassword())) {
            throw new MyRuntimeException("AuthorityServer", "用户名/密码不正确");
        }

        authorityTransmit.init(true, "成功", user);

        return authorityTransmit;
    }
}
