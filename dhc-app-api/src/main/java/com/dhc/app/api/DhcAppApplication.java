package com.dhc.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        //扫描的包路径
        scanBasePackages = {
                "com.dhc.app.api",
                "com.dhc.app.api.*.*.dao.po",
        }
        //不允许自动注入数据源，该项会导致jpa相关注解扫描实体类或Repository失败导致报错
//         exclude = {DataSourceAutoConfiguration.class}
)
//服务注册与发现，consul使用的
//@EnableDiscoveryClient
//事务相关，数据库service的实现方法上，加 @Transactional 就可以实现数据库事务，加到这里可以对全局的事务生效
@EnableTransactionManagement
//@MapperScan(basePackages = "com.dhc.app.api.service.*.dao", annotationClass = Mapper.class)
//使用swagger3 springboot3中停用
//@EnableOpenApi
//jpa扫描repository注入目录
@EnableJpaRepositories
public class DhcAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DhcAppApplication.class, args);
    }

}
