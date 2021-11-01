package com.nobug.experiment.jdk;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemTest {
    @Test
    public void nanoTimeTest () {
        String time = String.valueOf(System.currentTimeMillis());

        LocalDate localDate = LocalDate.now();

        String timeStamp = time.substring(time.length() - 6);

        String orderId = "WF" + localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) +
                timeStamp + RandomStringUtils.randomAlphabetic(5) + 111111;

        System.out.println(orderId);
        System.out.println(orderId.length());
    }
}
