package com.dhc.app.api.service.administrator.dao.po;

import com.dhc.app.api.service.common.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_administrator")
public class Administrator extends BaseModel {

    /**
     * 登陆名
     */
    private String longinName;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    public String getLonginName() {
        return longinName;
    }

    public void setLonginName(String longinName) {
        this.longinName = longinName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
