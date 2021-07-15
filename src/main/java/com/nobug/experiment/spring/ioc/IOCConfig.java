package com.nobug.experiment.spring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 14日 19:09:00
 */
@Configuration
public class IOCConfig {
    @Bean
    public Integer userId () {
        return 1;
    }
}
