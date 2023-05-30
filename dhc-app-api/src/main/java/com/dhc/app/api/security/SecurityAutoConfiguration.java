package com.dhc.app.api.security;

import com.dhc.app.api.security.jwt.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author donghongchen
 * @create 2023/5/15 13:46
 * @Description: springsecurity配置
 */
@Configuration
//Springboot的自动配置机制WebSecurityEnablerConfiguration已经引入了@EnableWebSecurity,此处不再需要
//当SecurityAutoConfiguration在启动类上被手动排除调时，不加的话 HttpSecurity http 就会报错
//@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityAutoConfiguration {

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final UserDetailsService userDetailsService;

    /**
     * 修改默认加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 基于用户名和密码或使用用户名和密码进行身份验证
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }


    /**
     * 配置过滤接口
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //关闭csrf(防止跨站请求伪造攻击)
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 免校验接口
                .authorizeHttpRequests(auth -> {
                    //同意所有请求
                    auth.requestMatchers(
                                    "/swagger**"
                                    ,"/*/api-docs"
                                    ,"/admin/api/administrators/login"
//                                    ,"/admin/api/administrators"
                            )
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                //过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
