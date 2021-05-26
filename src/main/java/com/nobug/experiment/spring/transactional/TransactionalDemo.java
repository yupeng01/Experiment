package com.nobug.experiment.spring.transactional;

import com.alibaba.fastjson.JSON;
import com.nobug.experiment.h2.dao.UserRepository;
import com.nobug.experiment.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 事务生效机制
 * @createTime 2021年 05月 25日 11:16:00
 */
@Component
public class TransactionalDemo {
    @Autowired
    TransactionalDemo transactionalDemo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionalDemo2 transactionalDemo2;


    public void deleteById (Long id) {
        //巴拉巴拉巴拉巴拉
        //操作数据库
//        transactionalDemo.test2();
//        User user = new User();
//        user.setId(id);
//        userRepository.delete(user);
//        List<User> userList = userRepository.findAll();
//        System.out.println(JSON.toJSONString(userList));
        test3(id);
        //throw new RuntimeException();
        //巴拉巴拉巴拉巴拉
    }

    @Transactional
    public void test2 () {

    }

    @Transactional
    public void test3 (Long id) {
        //操作数据库 service.save()....
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
        List<User> all = userRepository.findAll();
        System.out.println(JSON.toJSONString(all));
        throw new RuntimeException();
    }
}
