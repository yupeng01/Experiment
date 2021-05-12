package com.nobug.experiment.tool.mapstruct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 转换数据源
 * @createTime 2021年 05月 13:58:00
 */
@Accessors(chain = true)
@Getter
@Setter
public class MapStructSource {
    private String name;
    private String birthday;
    private int age;
    private Integer birthYear;
    private Teacher1 teacher;
}
