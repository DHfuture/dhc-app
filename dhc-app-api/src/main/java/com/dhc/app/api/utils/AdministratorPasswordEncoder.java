package com.dhc.app.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author donghongchen
 * @create 2023/5/15 15:19
 * @Description: 密码加密
 */
@Component
public class AdministratorPasswordEncoder {

    // spring security提供的bcrypt强哈希加密
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
