package com.nobug.experiment.jdk;

import java.math.BigDecimal;

public class FormatDemo {

    public static void main(String[] args) {
        FormatDemo demo = new FormatDemo();
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("15550")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("15500")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("15000")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("10000")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("1000")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("100")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("10")));
        System.out.println(demo.formatMoneyForShowingV2(new BigDecimal("1")));

    }

    private static final int TEN_THOUSAND = 10000;

    private static final int THOUSAND = 1000;

    public String formatMoneyForShowingV1(BigDecimal money){

        if(money.intValue() >= TEN_THOUSAND){
            if(money.intValue() % TEN_THOUSAND > 0) {
                double moneyDouble = money.doubleValue() / TEN_THOUSAND;
                if(money.intValue() % THOUSAND > 0) {
                    return String.format("%.2f", moneyDouble) + "万元";
                }else {
                    return String.format("%.1f", moneyDouble) + "万元";
                }
            }else{
                return money.intValue()/TEN_THOUSAND + "万元";
            }
        }else{
            return money.stripTrailingZeros().toPlainString() + "元";
        }
    }

    public String formatMoneyForShowingV2(BigDecimal money) {

        int intMoney = money.intValue();

        if (intMoney < TEN_THOUSAND) {
            return money.stripTrailingZeros().toPlainString() + "元";
        }
        if (intMoney % TEN_THOUSAND == 0) {
            return intMoney/TEN_THOUSAND + "万元";
        }

        double doubleMoney = money.doubleValue()/TEN_THOUSAND;

        if (intMoney % THOUSAND == 0) {
            return String.format("%.1f", doubleMoney) + "万元";
        }

        return String.format("%.2f", doubleMoney) + "万元";

    }

}
