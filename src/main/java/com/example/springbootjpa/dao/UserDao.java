package com.example.springbootjpa.dao;

import com.example.springbootjpa.po.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("from User o where o.username =:#{user.username}")
    User findByUserNameAndPWD(@Param("user") User user);
}
