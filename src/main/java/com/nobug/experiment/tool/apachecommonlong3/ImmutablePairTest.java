package com.nobug.experiment.tool.apachecommonlong3;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class ImmutablePairTest {
    private static ImmutablePair <Integer, String> getTwoValueTest () {
        return ImmutablePair.of(10, "100");
    }
    public static void main(String[] args) {
        ImmutablePair<Integer, String> twoValueTest = getTwoValueTest();
        System.out.println(twoValueTest.getLeft());
        System.out.println(twoValueTest.getRight());
    }
}
