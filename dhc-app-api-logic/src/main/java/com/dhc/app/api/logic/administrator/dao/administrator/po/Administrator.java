package com.dhc.app.api.logic.administrator.dao.administrator.po;

import com.dhc.app.api.logic.common.model.BaseModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_administrator")
public class Administrator extends BaseModel {

    /**
     * 登陆名
     */
    @Size(min = 5, max = 30, message = "登录名长度5-30")
    private String longinName;

    /**
     * 密码
     */
    @Size(min = 7, max = 30, message = "密码长度7-30")
    private String password;

    /**
     * 昵称
     */
    @Size(min = 1, max = 20, message = "昵称长度1-20")
    private String nickname;

}
