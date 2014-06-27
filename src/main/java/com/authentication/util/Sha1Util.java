package com.authentication.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import javax.annotation.Nonnull;

public class Sha1Util {

    @Nonnull
    public static String SHA1(@Nonnull String message) {
        byte[] b = message.getBytes(Charset.forName("UTF-8"));
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            b = md.digest(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(b);
    }

    @Nonnull
    public static String byteArrayToHexString(@Nonnull byte[] b) {
        String result = "";
        for (byte aB : b) {
            result += Integer.toString((aB & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }
}
