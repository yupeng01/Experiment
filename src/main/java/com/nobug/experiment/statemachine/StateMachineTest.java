package com.nobug.experiment.statemachine;

import com.nobug.experiment.statemachine.enums.TurnstileEvents;
import com.nobug.experiment.statemachine.enums.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 测试状态机的功能
 * @createTime 2021年 05月 15:39:00
 */
@Service
public class StateMachineTest implements StateMachinePersist<TurnstileStates, TurnstileEvents, Integer> {
    @Autowired
    private StateMachine<TurnstileStates, TurnstileEvents> stateMachine;
    static Map<Integer, TurnstileStates> cache = new HashMap<>(16);
    public void test () {
        stateMachine.start();
        System.out.println("--- coin ---");
        stateMachine.sendEvent(TurnstileEvents.COIN);
        System.out.println("--- coin ---");
        stateMachine.sendEvent(TurnstileEvents.COIN);
        System.out.println("--- push ---");
        stateMachine.sendEvent(TurnstileEvents.PUSH);
        System.out.println("--- push ---");
        stateMachine.sendEvent(TurnstileEvents.PUSH);
        stateMachine.stop();
    }

    @Override
    public void write(StateMachineContext<TurnstileStates, TurnstileEvents> stateMachineContext, Integer integer) throws Exception {
        cache.put(integer, stateMachineContext.getState());
    }

    @Override
    public StateMachineContext<TurnstileStates, TurnstileEvents> read(Integer integer) throws Exception {
        // 注意状态机的初识状态与配置中定义的一致
        return cache.containsKey(integer) ?
                new DefaultStateMachineContext<>(cache.get(integer), null, null, null, null, "turnstileStateMachine") :
                new DefaultStateMachineContext<>(TurnstileStates.Locked, null, null, null, null, "turnstileStateMachine");
    }
}
