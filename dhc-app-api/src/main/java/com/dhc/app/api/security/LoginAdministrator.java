package com.dhc.app.api.security;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author donghongchen
 * @create 2023/5/18 14:49
 * @Description:
 */
@Data
//生成无参构造函数
@NoArgsConstructor
//生成含有全部参数的构造函数
@AllArgsConstructor
public class LoginAdministrator implements UserDetails {

    private Administrator administrator;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return administrator.getPassword();
    }

    @Override
    public String getUsername() {
        return administrator.getLoginName();
    }

    /**
     * 用户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否启动
     * @return
     */
    @Override
    public boolean isEnabled() {
        return administrator.getEnable();
    }
}
