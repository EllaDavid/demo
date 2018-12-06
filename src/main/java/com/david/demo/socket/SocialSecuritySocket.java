package com.david.demo.socket;

import com.david.demo.socket.demo.HandleDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 社保通讯
 *
 * @2018-11-22
 * @David
 * @V1.0
 */
public class SocialSecuritySocket {
    private String serverIp;
    private int port;
    private Socket socket;
    private boolean running = false;    // 连接状态
    private long lastSendTime;  // 最后一次发送数据的时间

    private ConcurrentHashMap<String, IMessageAction> actionMapping = new ConcurrentHashMap<String, IMessageAction>();

    public SocialSecuritySocket(String serverIp, int port) {
        this.serverIp = serverIp;
        this.port = port;
    }

    /**
     * 添加接收对象的处理对象
     * @param message 处理对象的流水号
     * @param messageAction 处理过程对象
     */
    public void addAction(String message, IMessageAction messageAction) {
        actionMapping.put(message, messageAction);
    }

    /**
     * 移除已经处理的对象
     * @param message 处理对象的流水号
     */
    public void delAction(String message) {
        actionMapping.remove(message);
    }

    /**
     * 发送报文
     * @param message 报文
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes("GBK"));
        System.out.println("发送: " + message);
        outputStream.flush();
    }

    /**
     * 停止服务
     */
    public void stop() {
        if(running) {
            running = false;
        }
    }

    /**
     * 启动服务
     * @throws IOException
     */
    public void start() throws IOException {
        if(!running) {
            socket = new Socket(serverIp, port);
            System.out.println("本地端口：" + socket.getLocalPort());
            lastSendTime = System.currentTimeMillis();
            running = true;
            new Thread(new KeepAliveWatchDog()).start();  //保持长连接的线程，每隔2秒项服务器发一个一个保持连接的心跳消息
            new Thread(new ReceiveWatchDog()).start();    //接受消息的线程，处理消息
        }
    }


    /**
     * 心跳监测类
     */
    public class KeepAliveWatchDog implements Runnable {
        long checkDelay = 10;
        long keepAliveDelay = 1000;

        @Override
        public void run() {
            while(running) {
                if(System.currentTimeMillis()-lastSendTime>keepAliveDelay){
                    try {
                        SocialSecuritySocket.this.sendMessage(
                                "维持连接包: " + new SimpleDateFormat(
                                        "yyyy-MM-dd HH:mm:ss").format(new Date()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        SocialSecuritySocket.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else {
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        SocialSecuritySocket.this.stop();
                    }
                }
            }
        }
    }

    /**
     * 报文返回类
     */
    class ReceiveWatchDog implements Runnable{
        public void assignment(String rspMessage) {
            String[] messages = rspMessage.split("\\|");
            String txnNo = messages[2].trim();

            IMessageAction messageAction = actionMapping.get(txnNo);

            if(messageAction == null) {
                return;
            }

            messageAction.doAction(rspMessage);

            SocialSecuritySocket.this.delAction(txnNo);
        }

        @Override
        public void run() {
            while(running){
                try {
                    InputStream inputStream = socket.getInputStream();
                    if(inputStream.available() > 0){
                        byte[] bytes = new byte[512];
                        inputStream.read(bytes);
                        String rspMessage = new String(bytes, "GBK");

                        assignment(rspMessage);

                        System.out.println("接收: " + rspMessage);
                    }else{
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    SocialSecuritySocket.this.stop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String serverIp = "127.0.0.1";
        int port = 65432;
        SocialSecuritySocket client = new SocialSecuritySocket(serverIp, port);
        client.start();

        HandleDemo handleDemo = new HandleDemo();
        HandleDemo handleDemo1 = new HandleDemo();
        HandleDemo handleDemo2 = new HandleDemo();

        client.addAction("0001", handleDemo);
        client.addAction("0002", handleDemo1);
        client.addAction("0003", handleDemo2);
    }
}
