package com.quanxiaoha.weblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: weblog-springboot
 * @description: MyBatis Plus 配置
 * @author: wangyoulang
 * @create: 2024-06-08 14:46
 **/

@Configuration
@MapperScan("com.quanxiaoha.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}
