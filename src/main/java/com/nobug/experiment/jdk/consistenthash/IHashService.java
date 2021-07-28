package com.nobug.experiment.jdk.consistenthash;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description MurmurHash算法接口层
 * @createTime 2021年 07月 28日 11:22:00
 */
public interface IHashService {
    long hash (String key);
}
