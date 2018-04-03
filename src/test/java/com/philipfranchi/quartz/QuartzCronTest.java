package com.philipfranchi.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.WeeklyCalendar;
import org.quartz.spi.OperableTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzCronTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzCronTest.class);

    @Test
    public void canCreateCron() throws ParseException {
        CronExpression cron = new CronExpression("* * * ? * MON#3");
        System.out.println(cron.getNextValidTimeAfter(new Date()));
    }

    @Test
    public void canFireTriggerWithBadJob() throws SchedulerException {
        JobDetail job1 = JobBuilder.newJob(Job.class)
                .withIdentity("job1", "group1")
                .build();
        // Define a Trigger that will fire "now", and not repeat
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .build();
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        sched.scheduleJob(job1, trigger);
        LOGGER.info("Fire Time: {}", trigger.getNextFireTime());
    }

    @Test
    public void cronRepeatMonthTest() {
        //We want to see this go Feb -> July -> Dec -> May
        String cronExpression = "0 0 20 5 2/5 ? *";
        OperableTrigger trigger = (OperableTrigger) TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)
                .inTimeZone(TimeZone.getTimeZone("America/New_York")))
                .build();
        LOGGER.info("{}", TriggerUtils.computeFireTimes(trigger, new AnnualCalendar(), 20));
    }

    @Test
    public void cronRepeatMonthTest2() {
        String cronExpression = "0 0 20 5 3/2 ? *";
        OperableTrigger trigger = (OperableTrigger) TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)
                        .inTimeZone(TimeZone.getTimeZone("America/New_York")))
                .build();
        LOGGER.info("{}", TriggerUtils.computeFireTimes(trigger, new AnnualCalendar(), 20));
    }
}
