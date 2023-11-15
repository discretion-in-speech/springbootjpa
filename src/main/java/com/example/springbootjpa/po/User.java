package com.example.springbootjpa.po;

import jakarta.persistence.*;

/**
 * @author 闫加宽
 * @date 1.0
 * @version2023/11/14 8:33
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nikeName")
    private String nikeName;

    public User() {
    }

    public User(Long id, String username, String password, String nikeName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nikeName = nikeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
