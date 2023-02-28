package com.dhc.app.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author donghongchen
 * @create 2022/10/20 14:37
 * @Description:
 */
@Configuration
public class DhcAutoConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/test/**")
//                .hasAnyRole("user", "admin")
//                .antMatchers("/**")
                .authenticated();
        //省略HttpSecurity的配置
        return httpSecurity.build();
    }

}
