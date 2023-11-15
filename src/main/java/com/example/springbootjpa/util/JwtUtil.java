package com.example.springbootjpa.util;


import com.example.springbootjpa.po.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.platform.commons.util.StringUtils;


import java.util.Date;


public class JwtUtil {

    /**
     * 过期时间1小时，单位毫秒
     */
    public static final long EXPIRE = 1000*60*60*1;

    /*
    * 秘钥(盐)
    * */
    public static final String SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO1122";

    /**
     * claim user - 对象 -- 脱敏处理
     * 生成token字符串的方法
     * @return token字符串
     */
    public static String getJwtToken(User user)  {
        return Jwts.builder()
                //JWT头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS2256")
                //设置分类；设置过期时间 一个当前时间，一个加上设置的过期时间常量
                .setSubject("oracle")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置token主体信息，存储用户信息
                .claim("nickname", user.getNikeName())
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken  token串
     * @return 验证结果
     */
    public static boolean checkToken(String jwtToken){
        if (StringUtils.isBlank(jwtToken)){
            return false;
        }
        try{
            //验证token
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request  request
     * @return 验证结果
     */
    public static boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            if (StringUtils.isBlank(token)){
                return false;
            }
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 解密token
     *
     * @param request request
     * @return 解密结果map
     */
    public static User getMemberIdByJwtToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return decode(token);
    }

    /**
     * 解密token
     *
     * @param token token字符串
     * @return 解密结果map
     */
    public static User getMemberIdByJwtToken(String token){
        return decode(token);
    }

    public static User decode(String token) {
        // 封装解密结果
        if (org.springframework.util.StringUtils.isEmpty(token)){
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String nickname =  (String)body.get("nickname");
        Long id =  (Long)body.get("id");

        User user = new User();
        user.setNikeName(nickname);
        user.setId(id);

        return user;
    }
}
