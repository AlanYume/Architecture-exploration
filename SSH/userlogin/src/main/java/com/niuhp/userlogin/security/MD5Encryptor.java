package com.niuhp.userlogin.security;


import org.apache.logging.log4j.LogManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryptor implements Encryptor {

    private final static char[] HEX_CHARS =
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    @Override
    public String encrypt(final String inputStr) {
        String result = null;
        if (inputStr != null) {
            try {
                final MessageDigest md = MessageDigest.getInstance("MD5");
                final byte[] bytes = md.digest(inputStr.getBytes());
                result = bytes2HexString(bytes);
            } catch (final NoSuchAlgorithmException e) {
                LogManager.getLogger(getClass()).error("encrypt error !", e);
            }
        }
        return result;
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param 字节数组
     * @return 十六进制字符串
     */
    private static String bytes2HexString(final byte[] b) {
        final StringBuilder hexBuilder = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            hexBuilder.append(byteToHexChars(b[i]));
        }
        return hexBuilder.toString();
    }

    /** 将一个字节转化成十六进制形式的字符数组 */
    private static char[] byteToHexChars(final byte b) {
        final int n = byte2Int(b);
        final int d1 = n >> 4;
        final int d2 = n % 16;
        final char[] result = new char[2];
        result[0] = HEX_CHARS[d1];
        result[1] = HEX_CHARS[d2];
        return result;
    }

    private static int byte2Int(final byte b) {
        return b & 0xff;
    }
}
