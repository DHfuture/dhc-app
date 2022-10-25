package com.dhc.app.api.service.administrator.dao.po;

import com.dhc.app.api.service.common.model.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
