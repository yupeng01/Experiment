package com.nobug.experiment.apache;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class RandomStringUtilsTest {
    @Test
    public void randomAlphanumericTest() {
        String s = RandomStringUtils.randomAlphabetic(3);
        System.out.println(s);
    }
}
