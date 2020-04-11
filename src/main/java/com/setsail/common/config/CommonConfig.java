package com.setsail.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by SUNS3T
 * @Classname CommonConfig
 * @Description TODO
 * @Date 2020/4/11 7:02
 * 读取所有的系统配置
 * 项目配置文件，从application.properties中加载
 * 新建一个类，使用 @PropertySource 注解指定要读取的配置文件名称
 * 在属性上使用 @Value 注解指定要对应的配置项及默认值
 * 在类上使用 @Configuration 注解将其添加到 Spring 容器中
 */
@Configuration
@PropertySource("classpath:application.properties")
public class CommonConfig {
    @Value("${server.port:8111}")
    public String port;

    @Value("${server.address:http://127.0.0.1}")
    public String address;
}
