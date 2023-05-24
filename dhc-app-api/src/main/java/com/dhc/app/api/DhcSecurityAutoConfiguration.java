package com.dhc.app.api;

import com.dhc.app.api.service.administrator.LoginAdministrator;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import com.dhc.app.api.service.common.context.ApiContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class DhcSecurityAutoConfiguration {

    private final AdministratorQueryService administratorQueryService;

    /**
     * 用户详细信息  -> jwt身份验证过滤器
     * @param httpServletRequest
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return loginName -> {
            Administrator administrator = administratorQueryService.findOneByLoginName(loginName)
                    .orElseThrow(() -> new UsernameNotFoundException("用户没有找到"));
            return new LoginAdministrator(administrator);
        };
    }

    /**
     * 修改默认加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 身份校验机制、身份验证提供程序
     * @param userDetailsService
     * @param passwordEncoder
     * @return
     */
    @DependsOn(value = {"userDetailsService", "passwordEncoder"})
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                         PasswordEncoder passwordEncoder) {
        //创建一个用户认证提供者
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //设置用户相信信息，可以从数据库中读取、或者缓存、或者配置文件
        provider.setUserDetailsService(userDetailsService);
        //设置加密机制，若想要尝试对用户进行身份验证，我们需要知道使用的是什么编码
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    /**
     * 基于用户名和密码或使用用户名和密码进行身份验证
     * @param configuration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }








    /**
     * 配置HttpSecurity
     * 忽略一些接口校验
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 免校验接口
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(
//                                    "/admin/api/admin/administrators/login",
                                    "/swagger**",
                                    "/*/api-docs",
                                    "/admin/api/administrators/login"
                            )
                            .permitAll();
                });

        //把token校验过滤器添加到过滤器链中
//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
