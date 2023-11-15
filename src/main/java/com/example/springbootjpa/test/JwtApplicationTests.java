package com.example.springbootjpa.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;


import java.util.Calendar;

//@SpringBootTest
class JwtApplicationTests {

    public static String SECRET = "abzx";

    @Test
    void contextLoads() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,2);

        //创建令牌
        String token = JWT.create()
                .withHeader(null)  //配置头信息
                .withClaim("uname", "张三")
                .withClaim("role", "admin")
                .withClaim("age", 33)
                .withExpiresAt(calendar.getTime()) //配置生效时间
                .sign(Algorithm.HMAC256(this.SECRET));
        System.out.println(token);
    }

    @Test
    void checkToken(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJ1bmFtZSI6IuW8oOS4iSIsImV4cCI6MTY5OTg2NTMwMywiYWdlIjozM30.DeOSZg4R8-VRWFeJN_L6Ke1Gqla3GImVLcBnTdRJfKI";

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            System.out.println("verifier = " + verifier);
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("jwt = " + jwt);
            //TWT是通过异常来校验当前是否验证通过的。
        } catch (SignatureVerificationException e) {
            System.out.println("签名不一致！");
            e.printStackTrace();
        } catch (TokenExpiredException e) {
            System.out.println("token过期！");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e) {
            System.out.println("算法匹配异常！");
            e.printStackTrace();
        }catch (InvalidClaimException | JWTDecodeException e) {
            System.out.println("失效的payload异常！");
            e.printStackTrace();
        }
    }
}
