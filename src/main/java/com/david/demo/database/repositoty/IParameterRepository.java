package com.david.demo.database.repositoty;

import com.david.demo.database.prototype.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 系统参数表操作接口
 *
 * @2018-11-28
 * @David
 */
@Repository
public interface IParameterRepository extends JpaRepository<Parameter, Long> {
}
