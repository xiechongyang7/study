package com.seesea.study.model;

import com.seesea.rely.annotation.FunAn;
import com.seesea.rely.annotation.Name;

import java.io.Serializable;
import javax.persistence.*;

@Name(value = "User")
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    private Long id;

    /**
     * 居住地址
     */
    @Column(name = "homeAddress")
    private String homeaddress;

    @Column(name = "homeTel")
    private Long hometel;

    @Column(name = "userName")
    private String username;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取居住地址
     *
     * @return homeAddress - 居住地址
     */
    public String getHomeaddress() {
        return homeaddress;
    }

    /**
     * 设置居住地址
     *
     * @param homeaddress 居住地址
     */
    @FunAn
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    /**
     * @return homeTel
     */
    public Long getHometel() {
        return hometel;
    }

    /**
     * @param hometel
     */
    public void setHometel(Long hometel) {
        this.hometel = hometel;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", homeaddress=").append(homeaddress);
        sb.append(", hometel=").append(hometel);
        sb.append(", username=").append(username);
        sb.append("]");
        return sb.toString();
    }
}