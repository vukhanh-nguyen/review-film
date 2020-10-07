package com.citynow.utils;

import java.io.UnsupportedEncodingException;

public class ConvertUtil {

    public static String convertBytesToString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static byte[] convertStringToBytes(String string) {
        return string.getBytes();
    }
}
