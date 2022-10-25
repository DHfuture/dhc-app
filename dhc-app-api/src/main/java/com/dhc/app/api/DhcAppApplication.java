package com.dhc.app.api;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {
                "com.dhc.app.api",
        },
        exclude = {DataSourceAutoConfiguration.class}
)
//swagger文档
@EnableSwagger2
//服务注册与发现，consul使用的
//@EnableDiscoveryClient
//事务相关，数据库service的实现方法上，加 @Transactional 就可以实现数据库事务了
@EnableTransactionManagement
@MapperScan(basePackages = "com.dhc.app.api.service.administrator.dao", annotationClass = Mapper.class)
public class DhcAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DhcAppApplication.class, args);
    }

}
