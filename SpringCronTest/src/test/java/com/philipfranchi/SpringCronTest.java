package com.philipfranchi;

import org.junit.Test;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

public class SpringCronTest {

    @Test
    public void canParseCronExpression() {
        CronTrigger ct = new CronTrigger("0 0 13 1/1 * ?");
        SimpleTriggerContext stc = new SimpleTriggerContext();
        System.out.println("Next Time" + ct.nextExecutionTime(stc).toInstant().toString());
    }
}
