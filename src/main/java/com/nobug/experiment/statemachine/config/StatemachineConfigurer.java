package com.nobug.experiment.statemachine.config;

import com.nobug.experiment.statemachine.enums.TurnstileEvents;
import com.nobug.experiment.statemachine.enums.TurnstileStates;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 状态机配置，其中turnstileUnlock() 和 customerPassAndLock()即为当前状态变更后的扩展业务操作，可以根据实际业务场景进行修改
 * @createTime 2021年 05月 15:27:00
 */
@Configuration
@EnableStateMachine
public class StatemachineConfigurer extends EnumStateMachineConfigurerAdapter<TurnstileStates, TurnstileEvents> {
    @Override
    public void configure(StateMachineStateConfigurer<TurnstileStates, TurnstileEvents> states) throws Exception {
        states.withStates()
                .initial(TurnstileStates.Unlocked)
                .states(EnumSet.allOf(TurnstileStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<TurnstileStates, TurnstileEvents> transitions) throws Exception {
        transitions.withExternal()
                .source(TurnstileStates.Unlocked).target(TurnstileStates.Locked)
                .event(TurnstileEvents.COIN).action(customerPassAndLock())
                .and()
                .withExternal()
                .source(TurnstileStates.Locked).target(TurnstileStates.Unlocked)
                .event(TurnstileEvents.PUSH).action(turnstileUnlock());
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<TurnstileStates, TurnstileEvents> config) throws Exception {
        config.withConfiguration()
                .machineId("turnstileStateMachine")
        ;
    }

    public Action<TurnstileStates, TurnstileEvents> turnstileUnlock() {
        return context -> System.out.println("解锁旋转门，以便游客能够通过" );
    }

    public Action<TurnstileStates, TurnstileEvents> customerPassAndLock() {
        return context -> System.out.println("当游客通过，锁定旋转门" );
    }
}
