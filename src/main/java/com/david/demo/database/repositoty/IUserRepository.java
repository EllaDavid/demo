package com.david.demo.database.repositoty;

import com.david.demo.database.prototype.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    // 根据员工号获得实例
    public User findByEmpno(String empno);
}
