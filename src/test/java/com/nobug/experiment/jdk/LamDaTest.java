package com.nobug.experiment.jdk;

import com.alibaba.fastjson.JSON;
import com.nobug.experiment.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LamDaTest {
    @Test
    public void lamDaTest () {
        List<Person> list = new ArrayList();
        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data0\",\n" +
                "  \"age\": 50,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2013-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data1\",\n" +
                "  \"age\": 54,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2014-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data2\",\n" +
                "  \"age\": 54,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2015-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data3\",\n" +
                "  \"age\": 54,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2016-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data4\",\n" +
                "  \"age\": 54,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2017-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data5\",\n" +
                "  \"age\": 53,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2018-12-05 18:35:35\"\n" +
                "}", Person.class));

        list.add(JSON.parseObject("{\n" +
                "  \"name\": \"fake_data6\",\n" +
                "  \"age\": 55,\n" +
                "  \"phone\": \"fake_data\",\n" +
                "  \"CreateTime\": \"2019-12-05 18:35:35\"\n" +
                "}", Person.class));

        List<Person> result = list.stream().filter(item -> item.getAge().equals(54)).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result));
        Assert.assertEquals("fake_data1", result.get(0).getName());
        Assert.assertEquals("fake_data2", result.get(1).getName());
        Assert.assertEquals("fake_data3", result.get(2).getName());
        Assert.assertEquals("fake_data4", result.get(3).getName());
    }
}
