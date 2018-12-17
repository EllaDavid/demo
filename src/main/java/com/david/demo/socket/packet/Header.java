package com.david.demo.socket.packet;

/**
 * 报文头（定长）-不可用中文
 * @2018-12-17
 * @David
 */
public class Header {
    private String code;    // 4位交易码
    private String result;  // 2位交易结果
    private String serialNumber;    // 18位流水号
    private String fileLength;  // 10位文件长度
    private String fileName;    // 30位文件名

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 初始化
     * @param code
     * @param result
     * @param serialNumber
     * @param fileLength
     * @param fileName
     */
    public void init(String code, String result, String serialNumber, String fileLength, String fileName) {
        this.code = code;
        this.result = result;
        this.serialNumber = serialNumber;
        this.fileLength = fileLength;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        String str = String.format("%4s|%2s|%18s|%10s|%30s|", code, result, serialNumber, fileLength, fileName);

        return str;
    }
}
