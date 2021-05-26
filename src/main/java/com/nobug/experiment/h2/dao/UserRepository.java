package com.nobug.experiment.h2.dao;

import com.nobug.experiment.h2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 25日 17:32:00
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
