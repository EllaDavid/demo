package com.david.demo;

import com.david.demo.socket.packet.Header;
import org.junit.Test;

/**
 * 程序片段测试
 * @2018-12-17
 * @David
 */
public class FragmentTest {
    @Test
    public void PacketHeader_toString_test() {
        Header ph = new Header("code","00", "123456", "0212",
                "你好");
        System.out.println(ph.toString());
    }
}
