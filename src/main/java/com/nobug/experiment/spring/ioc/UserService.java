package com.nobug.experiment.spring.ioc;

import org.springframework.stereotype.Service;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 14日 19:06:00
 */
@Service
public class UserService {
    public UserService (User user, OrderService orderService) {
        System.out.println("进入构造器1");
    }
    public UserService (User user, OrderService orderService, Integer userId) {
        System.out.println("进入构造器2");
    }
}
