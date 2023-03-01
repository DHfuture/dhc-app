package com.dhc.app.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author donghongchen
 * @create 2022/10/20 14:37
 * @Description:
 */
//表明这是一个配置类
@Configuration
//jpa扫描repository注入目录
@EnableJpaRepositories
//@EnableJpaRepositories(basePackages = "com.dhc.app.api.service.administrator.dao")
//扫描JPA实体类
//@EntityScan(basePackages = {"com.dhc.app.api.service.administrator.dao.po"})
public class DhcAutoConfiguration {

}
