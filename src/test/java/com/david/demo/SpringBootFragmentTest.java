package com.david.demo;

import com.david.demo.constant.SystemContents;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot程序片段测试
 * @2018-12-17
 * @David
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFragmentTest {
    @Autowired
    SystemContents systemContents;

    @Test
    public void testParam() {
        System.out.println(systemContents.getBankCode());
    }
}
