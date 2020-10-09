package com.citynow.utils;

import java.io.BufferedReader;
import java.io.IOException;
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

    public static String convertJsonToString(BufferedReader reader){
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return sb.toString();
    }
}
