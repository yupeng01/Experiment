package com.nobug.experiment.consistenthash;

import java.util.*;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 一致性hash测试
 * @createTime 2021年 07月 28日 11:28:00
 */
public class ConsistentHashTest {
    // 机器节点IP前缀
    private static final String IP_PREFIX = "192.168.0.";

    public static void main(String[] args) {
        // 每台真实机器节点上保存的记录条数
        Map<String, Integer> map = new HashMap<String, Integer>();

        // 真实机器节点, 模拟10台
        List<Node<String>> nodes = new ArrayList<Node<String>>();
        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0); // 初始化记录
            Node<String> node = new Node<String>(IP_PREFIX + i, "node" + i);
            nodes.add(node);
        }

        IHashService iHashService = new HashService();
        // 每台真实机器引入100个虚拟节点
        ConsistentHash<Node<String>> consistentHash = new ConsistentHash<Node<String>>(iHashService, 10000, nodes);

        List<String> dataList = new ArrayList<>();
        // 将5000条记录尽可能均匀的存储到10台机器节点上
        for (int i = 0; i < 5000; i++) {
            // 产生随机一个字符串当做一条记录，可以是其它更复杂的业务对象,比如随机字符串相当于对象的业务唯一标识
            String data = UUID.randomUUID().toString() + i;
            dataList.add(data);
            // 通过记录找到真实机器节点
            Node<String> node = consistentHash.get(data);
            // 再这里可以能过其它工具将记录存储真实机器节点上，比如MemoryCache等
            // ...
            // 每台真实机器节点上保存的记录条数加1
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }

        // 打印每台真实机器节点保存的记录条数
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get(IP_PREFIX + i));
        }

        consistentHash.remove(nodes.get(1));
        System.out.println("模拟节点2挂掉");
        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0);
        }
        System.out.println("重置了map");
        // 打印每台真实机器节点保存的记录条数
        for (String data : dataList) {
            // 通过记录找到真实机器节点
            Node<String> node = consistentHash.get(data);
            // 再这里可以能过其它工具将记录存储真实机器节点上，比如MemoryCache等
            // ...
            // 每台真实机器节点上保存的记录条数加1
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get(IP_PREFIX + i));
        }
    }
}