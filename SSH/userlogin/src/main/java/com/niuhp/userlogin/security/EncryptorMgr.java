package com.niuhp.userlogin.security;

public class EncryptorMgr {

    private static Encryptor encryptor = new MD5Encryptor();

    private EncryptorMgr() {
    }

    public static String encrypt(final String input) {
        return encrypt(EncryptorMgr.encryptor, input);
    }

    public static String encrypt(final Encryptor encryptor, final String input) {
        return encryptor.encrypt(input);
    }

    public static void switchEncryptor(final Encryptor encryptor) {
        EncryptorMgr.encryptor = encryptor;
    }
}
