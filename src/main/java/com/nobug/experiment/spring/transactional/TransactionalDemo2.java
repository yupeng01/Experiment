package com.nobug.experiment.spring.transactional;

import com.alibaba.fastjson.JSON;
import com.nobug.experiment.h2.dao.UserRepository;
import com.nobug.experiment.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 25日 18:18:00
 */
@Component
public class TransactionalDemo2 {
    @Autowired
    private UserRepository userRepository;
    public void deleteById (Long id) {
        //巴拉巴拉巴拉巴拉
        //操作数据库
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
        List<User> all = userRepository.findAll();
        System.out.println(JSON.toJSONString(all));
        throw new RuntimeException();
    }

}
