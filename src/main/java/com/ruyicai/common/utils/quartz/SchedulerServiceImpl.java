package com.ruyicai.common.utils.quartz;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {
	private static int START_TIME_DELAY=60;
	private static Scheduler scheduler;
	// private static SchedulerServiceImpl instance = new
	// SchedulerServiceImpl();
	private boolean started = false;

	// public static SchedulerServiceImpl getInstance() {
	// return instance;
	// }
	// @Autowired
	// public void setScheduler(@Qualifier("quartzScheduler") Scheduler
	// scheduler) {
	// this.sched = scheduler;
	// }
	public SchedulerServiceImpl() {
		try {
			scheduler = QuartzUtil.createScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startScheduler() {
		try {
			if (started)
				return;
			QuartzUtil.startScheduler(scheduler);
			started = true;
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopScheduler() {
		try {
			if (!started)
				return;
			QuartzUtil.stopScheduler(scheduler, false);
			started = false;
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listScheduler() {
		try {
			QuartzUtil.listJobinScheduler(scheduler);
			QuartzUtil.listTriggerinScheduler(scheduler);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void interruptSchedulerJob(JobDetail jobDetail) {
		try {
			QuartzUtil.interruptScheduler(scheduler, jobDetail);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addJobTrigger(Class jobClass, Date runTime, String jobName,
			String groupName, Map params) {
		try {
			JobDetail job = QuartzUtil.createJob(jobClass, jobName, groupName,
					params);

			Trigger trigger = QuartzUtil.createSimpleTrigger(runTime, "trigger"
					+ jobName, groupName);

			QuartzUtil.scheduleJob(scheduler, job, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addJobTrigger(Class jobClass, String cronExp, String jobName,
			String groupName, Map params) {
		try {
			JobDetail job = QuartzUtil.createJob(jobClass, jobName, groupName,
					params);

			CronTrigger trigger = QuartzUtil.createCronTrigger(cronExp,
					"trigger" + jobName, groupName);
			trigger.setStartTime(new Date(System.currentTimeMillis()+60*1000));
			//trigger.setStartTime(new Date(d.getTime()+(int)(Math.random()*300000)));
			trigger.setJobName(jobName);
			QuartzUtil.scheduleJob(scheduler, job, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTrigger(String jobName, String groupName, String cronExp) {
		try {
			QuartzUtil.updateTrigger(scheduler, jobName, groupName, cronExp);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateJob(Class<Job> jobClass, String cronExp, String jobName,
			String groupName, Map params) {
		try {
			QuartzUtil.updateJob(scheduler, jobClass, jobName, groupName,
					params, cronExp);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void pauseTrigger(String triggerName, String group) {
		try {
			QuartzUtil.pauseTrigger(scheduler, triggerName, group);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void resumeTrigger(String triggerName, String group) {
		try {
			QuartzUtil.resumeTrigger(scheduler, triggerName, group);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean removeTriggger(String triggerName, String group) {
		try {
			return QuartzUtil.removeTrigdger(scheduler, triggerName, group);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public  boolean validCron(String cronExpression)  {
		try {
			boolean valid= QuartzUtil.validCron(cronExpression);
			if(!valid)return false;
			CronTrigger trigger = QuartzUtil.createCronTrigger(cronExpression,
					"trigger" , "group");
			Date d=	new Date(System.currentTimeMillis()+START_TIME_DELAY*1000);
		     return	trigger.getFireTimeAfter(d)!=null;
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}