package com.nobug.experiment.jdk;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    @Test
    public void getTimeStampTest () {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        LocalDate ago = LocalDate.of(2021, 9, 21);

        System.out.println(year + "-" + month);
        System.out.println(ago.format(DateTimeFormatter.ofPattern("yyyy-MM")));
    }
}
