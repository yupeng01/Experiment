package com.nobug.experiment.controller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 测试实体
 * @createTime 2021年 05月 19日 18:16:00
 */
@Data
@NoArgsConstructor
public class BigDecimalDemoEntity {
    private BigDecimal value;
    private String name;
}
