package com.nobug.experiment.jdk;

import org.junit.Assert;
import org.junit.Test;

public class PassByValueTest {

    public void dynamicMethod(Integer value) {
        value -= 10;
    }

    public static void staticMethod(Integer value) {
        value -= 10;
    }

    @Test
    public void testMethod() {
        Integer value = 11;
        staticMethod(11);
        Assert.assertEquals(11, (int)value);
        new PassByValueTest().dynamicMethod(value);
        Assert.assertEquals(11, (int)value);
    }
}
