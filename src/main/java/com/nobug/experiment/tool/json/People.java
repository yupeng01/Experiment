package com.nobug.experiment.tool.json;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class People {
    private String name;
    private int age;
}
