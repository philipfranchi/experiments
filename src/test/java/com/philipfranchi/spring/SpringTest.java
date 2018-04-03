package com.philipfranchi.spring;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.client.RestTemplate;

public class SpringTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void canParseCronExpression() {
        CronTrigger ct = new CronTrigger("* 1 * * * MON");
        SimpleTriggerContext stc = new SimpleTriggerContext();
        System.out.println("Next Time" + ct.nextExecutionTime(stc).toInstant().minusSeconds(
                5*60*60
        ).toString());
    }

    @Test
    public void canConstructDummyController() {
        //restTemplate.postForEntity();
    }
}
