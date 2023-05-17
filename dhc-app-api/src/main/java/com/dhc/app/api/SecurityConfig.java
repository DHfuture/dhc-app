//package com.dhc.app.api;
//
//import com.dhc.app.api.utils.AdministratorPasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//import javax.sql.DataSource;
//
///**
// * @Author donghongchen
// * @create 2023/5/15 13:46
// * @Description:
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    public static final String QUERY_ADMINISTRATOR = "select login_name as username, password, enable as enabled from t_administrator where login_name = ?";
//
//    public static final String QUERY_ADMINISTRATOR_AUTH = "select login_name as username, authority from t_administrator where login_name = ?";
//
//
//    @Autowired
//    DataSource dataSource;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(QUERY_ADMINISTRATOR)
//                .authoritiesByUsernameQuery(QUERY_ADMINISTRATOR_AUTH)
//                .passwordEncoder(new AdministratorPasswordEncoder());
//    }
//
//}
