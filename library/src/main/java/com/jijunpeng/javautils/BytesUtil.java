package com.jijunpeng.javautils;

/**
 * Created by jijunpeng on 17/3/13.
 */
public class BytesUtil {
    public static char[] hex = "0123456789ABCDEF".toCharArray();

    public static String bytesToHexStr(byte... bytes) {
        char[] result = new char[bytes.length * 2];
        int resultIndex;
        for (int i = 0; i < bytes.length; i++) {
            resultIndex = 2 * i;
            result[resultIndex] = hex[(bytes[i] >> 4) & 0x0F];
            result[resultIndex + 1] = hex[bytes[i] & 0x0F];
        }
        return new String(result);
    }

    public static byte[] hexStrToBytes(String byteStr) {
        if (byteStr == null) {
            return null;
        }
        if (byteStr.length() % 2 != 0) {
            throw new RuntimeException("byteStr长度不是偶数，没法转");
        }
        int resultLen = byteStr.length() / 2;
        byte[] result = new byte[resultLen];
        char h, l;
        byte b;
        byteStr = byteStr.toUpperCase();
        int strIndex;
        for (int i = 0; i < resultLen; i++) {
            strIndex = 2 * i;
            h = byteStr.charAt(strIndex);
            if ('0' <= h && h <= '9') {
                b = (byte) ((h - '0') << 4);
            } else if ('A' <= h && h <= 'F') {
                b = (byte) ((h - 'A' + 10) << 4);
            } else {
                throw new RuntimeException("byteStr 的第" + i + "个字符 不在16进制范围中");
            }
            l = byteStr.charAt(strIndex + 1);
            if ('0' <= l && l <= '9') {
                // b |= (byte) (0x0F & (l - '0'));
                b |= (byte) (l - '0');
            } else if ('A' <= l && l <= 'F') {
                // b |= (byte) (0x0F & (l - 'A' + 10));
                b |= (byte) (l - 'A' + 10);
            } else {
                throw new RuntimeException("byteStr 的第" + (i + 1) + "个字符 不在16进制范围中");
            }
            result[i] = b;
        }
        return result;
    }
}