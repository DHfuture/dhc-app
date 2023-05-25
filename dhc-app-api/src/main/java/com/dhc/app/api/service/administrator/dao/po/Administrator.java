package com.dhc.app.api.service.administrator.dao.po;

import com.dhc.app.api.service.administrator.constants.AdministratorRole;
import com.dhc.app.api.service.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data 自动生成常见的类方法，如 getter、setter、equals()、hashCode() 和 toString() 等
@Data
//@EqualsAndHashCode 用于在生成 equals() 和 hashCode() 方法时考虑父类的字段
//callSuper = true 生成的 equals() 和 hashCode() 方法将不考虑父类的字段
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_administrator")
@Table(
        //和@Entity中的用法一样
        // name = "t_administrator",

        //唯一索引
        uniqueConstraints = {
                @UniqueConstraint(name = "loginName", columnNames = {"loginName"}),
        },

        //普通索引
        indexes = {
                @Index(name = "created", columnList = "created ASC, modified DESC", unique = false),
        }
)
public class Administrator extends BaseModel {

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 密码
     */
    @Column(length = 533, columnDefinition = "TEXT")
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 权限
     */
    @Enumerated(EnumType.STRING)
    private AdministratorRole authority;

}
