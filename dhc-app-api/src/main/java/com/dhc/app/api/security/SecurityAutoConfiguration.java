package com.dhc.app.api.security;

import com.dhc.app.api.security.jwt.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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

//    private final AdministratorQueryService administratorQueryService;
//
//    // 在ApplicationConfig中提供Bean
////    private final LogoutHandler logoutHandler;
//
//    /**
//     * 用户详细信息  -> jwt身份验证过滤器
//     *
//     * @return
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return loginName -> {
//            Administrator administrator = administratorQueryService.findOneByLoginName(loginName)
//                    .orElseThrow(() -> new UsernameNotFoundException("用户没有找到"));
//            return new LoginAdministrator(administrator);
//        };
//    }
//
//    /**
//     * 身份校验机制、身份验证提供程序
//     *
//     * @param userDetailsService
//     * @param passwordEncoder
//     * @return
//     */
//    @DependsOn(value = {"userDetailsService", "passwordEncoder"})
//    @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
//                                                         PasswordEncoder passwordEncoder) {
//        //创建一个用户认证提供者
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        //设置用户相信信息，可以从数据库中读取、或者缓存、或者配置文件
//        provider.setUserDetailsService(userDetailsService);
//        //设置加密机制，若想要尝试对用户进行身份验证，我们需要知道使用的是什么编码
//        provider.setPasswordEncoder(passwordEncoder);
//        return provider;
//    }

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
                            .permitAll();
                })
                //过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

//        http
//                //禁用csrf(防止跨站请求伪造攻击)
//                .csrf()
//                .disable()
//                // 设置白名单
//                .authorizeHttpRequests()
//                .requestMatchers(
//                        "/swagger**",
//                        "/*/api-docs",
//                        "/admin/api/administrators/login"
//                )
//                .permitAll()
//                // 对于其他任何请求，都保护起来
//                .anyRequest()
//                .authenticated()
//                .and()
//                // 禁用缓存
//                .sessionManagement()
//                // 使用无状态session，即不使用session缓存数据
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                // 添加身份验证
//                .and()
//                // TODO 添加身份验证1
//                .authenticationProvider(authenticationProvider)
//                // 添加JWT过滤器
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                // 登出操作
////                .logout()
////                .logoutUrl("/api/v1/auth/logout")
////                .addLogoutHandler(logoutHandler)
////                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
//        ;

        return http.build();
    }


}
