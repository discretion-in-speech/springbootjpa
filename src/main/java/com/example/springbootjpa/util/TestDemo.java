package com.example.springbootjpa.util;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //cookie
        String str = "中国";
        String encodeStr = URLEncoder.encode(str, "utf-8");
        System.out.println("encodeStr : " + encodeStr);

//        Cookie cookie = new Cookie("str",str);

        String decodeStr = URLDecoder.decode(str, "utf-8");
        System.out.println("decodeStr : " + decodeStr);


    }

}
