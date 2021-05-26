package com.nobug.experiment.controller;

import com.nobug.experiment.h2.dao.UserRepository;
import com.nobug.experiment.h2.entity.User;
import com.nobug.experiment.spring.transactional.TransactionalDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 25日 17:33:00
 */
@RestController
public class H2UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionalDemo transactionalDemo;
    @GetMapping("/user/{id}")
    public User findById (@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @GetMapping("/user/delete/{id}")
    public void deleteById (@PathVariable Long id) {
        transactionalDemo.deleteById(id);
    }

    @GetMapping("/user/all")
    public Object findById () {
        return userRepository.findAll();
    }
}
