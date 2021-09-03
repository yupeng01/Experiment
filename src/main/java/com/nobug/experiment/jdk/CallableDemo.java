package com.nobug.experiment.jdk;

import java.util.concurrent.Callable;

public class CallableDemo {
}

class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
