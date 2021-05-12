package com.nobug.experiment.tool.mapstruct;

import com.alibaba.fastjson.JSON;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description a demo of mapstruct TODO 暂未跑通
 * @createTime 2021年 05月 14:09:00
 */
public class MapStructDemo {
    public static void main(String[] args) {
        MapStructSource mapStructSource = new MapStructSource();
        Teacher1 teacher = new Teacher1();
        teacher.setName("muwenbin").setAge(40);
        mapStructSource.setName("liyupeng01")
                .setBirthday(null)
                .setBirthYear(null)
                .setAge(23)
                .setTeacher(teacher);

        MapStructTarget mapStructTarget = MapStructTargetConverter.INSTANCE.toMapStructTarget(mapStructSource);
        System.out.println(JSON.toJSONString(mapStructSource));
        System.out.println(JSON.toJSONString(mapStructTarget));
    }
}
