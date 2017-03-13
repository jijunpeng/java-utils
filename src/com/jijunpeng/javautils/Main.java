package com.jijunpeng.javautils;

import com.jijunpeng.javautils.BytesUtil;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(BytesUtil.bytesToHexStr(new byte[]{0x11, 0x22, 0x33, 0x44}));

        byte[] bytes = BytesUtil.hexStrToBytes("11223344");
        System.out.println(BytesUtil.bytesToHexStr(bytes));
    }
}
