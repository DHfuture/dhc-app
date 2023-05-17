package com.dhc.app.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author donghongchen
 * @create 2022/10/20 14:37
 * @Description:
 */
//表明这是一个配置类
@Configuration
//@EnableJpaRepositories(basePackages = "com.dhc.app.api.service.administrator.dao")
//扫描JPA实体类
//@EntityScan(basePackages = {"com.dhc.app.api.service.administrator.dao.po"})
public class DhcAutoConfiguration {

    //swagger3接口文档
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("dhc接口文档").version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/**")
                .build();
    }

}
