package com.nobug.experiment.regix;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    @Test
    public void matchBankCard () {
        Assert.assertFalse(match("^\\d{1,30}", "5555a5"));
        Assert.assertFalse(match("^\\d{1,30}", ""));
        Assert.assertFalse(match("^\\d{1,10}", "11111111111"));
        Assert.assertTrue(match("^\\d{1,10}.*$", "11111111111"));
    }

    private boolean match(String regex, String param) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        return matcher.matches();
    }

    @Test
    public void matchEmail () {
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Assert.assertTrue(match(regex, "222@qq.com"));
        Assert.assertTrue(match(regex, "ss222@163.com"));
        Assert.assertTrue(match(regex, "11@13.com"));
        Assert.assertFalse(match(regex, "@13.com"));
        Assert.assertFalse(match(regex, "22213.com"));
        Assert.assertFalse(match(regex, "22213@"));
    }

    @Test
    public void matchPhone () {
        String regex = "^(1[0-9][0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        Assert.assertTrue(match(regex, "13031088888"));
        Assert.assertTrue(match(regex, "17031088888"));
        Assert.assertTrue(match(regex, "18031088888"));
        Assert.assertTrue(match(regex, "19231088888"));
        Assert.assertTrue(match(regex, "15222222222"));

        Assert.assertFalse(match(regex, "1522222222"));
        Assert.assertFalse(match(regex, "192222222211"));
        Assert.assertFalse(match(regex, "2522222222"));
        Assert.assertFalse(match(regex, "3522222222"));
    }

    @Test
    public void matchIdentifyCard() {
        String regex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
        Assert.assertTrue(match(regex, "230123456789101111"));
        Assert.assertTrue(match(regex, "23012345678910111X"));
        Assert.assertTrue(match(regex, "23012345678910111x"));
        Assert.assertTrue(match(regex, "230333344441112"));

        Assert.assertFalse(match(regex, "23012345678910111A"));
        Assert.assertFalse(match(regex, "2303333444411123"));
        Assert.assertFalse(match(regex, "23012345678910111"));
        Assert.assertFalse(match(regex, "23012345678910111Xa"));
        Assert.assertFalse(match(regex, "2301234567891011111"));
    }
}
