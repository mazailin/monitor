package com.ruyicai.common.utils.quartz;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * @Auther: tsj
 */
public class QuartzUtil {
	static Logger log = Logger.getLogger(QuartzUtil.class);

	public static void initQuartzTrigger(Class jobClass, String cronExp,
			String jobName, String groupName, Map params)
			throws SchedulerException, ParseException {
		Scheduler scheduler = createScheduler();
		JobDetail job = createJob(jobClass, jobName, groupName, params);

		CronTrigger trigger = createCronTrigger(cronExp, jobName,
				groupName);

		scheduleJob(scheduler, job, trigger);

		startScheduler(scheduler);
	}

	public static Scheduler createScheduler() throws SchedulerException,
			ParseException {
		log.info("------- Initializing -------------------");
		// Initiate a Schedule Factory
		// First we must get a reference to a scheduler
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		// Retrieve a scheduler from schedule factory
		Scheduler scheduler = schedulerFactory.getScheduler();

		log.info("------- Initialization Complete --------");

		return scheduler;
	}

	public static void scheduleJob(Scheduler scheduler, JobDetail jobDetail,
			Trigger trigger) throws SchedulerException, ParseException {
		// schedule a job with JobDetail and Trigger
		Date ft = scheduler.scheduleJob(jobDetail, trigger);
		if (trigger instanceof CronTrigger)
			log.info(jobDetail.getKey() + " has been scheduled to run at: "
					+ ft + " and repeat based on expression: "
					+ ((CronTrigger) trigger).getCronExpression());
		if (trigger instanceof SimpleTrigger)
			log.info(jobDetail.getKey() + " will run at: " + ft
					+ " and repeat: "
					+ ((SimpleTrigger) trigger).getRepeatCount()
					+ " times, every "
					+ ((SimpleTrigger) trigger).getRepeatInterval() / 1000
					+ " seconds");
	}

	public static JobDetail createJob(Class jobClass, String jobName,
			String groupName, Map params) throws SchedulerException,
			ParseException {

		log.info("------- create Scheduling Jobs ----------------");
		// jobs can be scheduled before sched.start() has been called
		

		JobDetail jobDetail = new JobDetail(jobName, groupName, jobClass);
		if (params != null && params.size() > 0) {
			java.util.Iterator it = params.entrySet().iterator();
			while (it.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
				String key = (String) entry.getKey();
				Object s =  entry.getValue();

				jobDetail.getJobDataMap().put(key, s);
			}

		}
		return jobDetail;
	}

	public static Trigger createSimpleTrigger(Date runTime, String triggerName,
			String groupName) throws SchedulerException, ParseException {
		log.info("------- create Scheduling cronTrigger ----------------");
		Trigger trigger = new SimpleTrigger(triggerName, groupName, runTime);
		return trigger;
	}

	// Trigger the job to run on the next round minute
	public static CronTrigger createCronTrigger(String cronExp,
			String triggerName, String jobName,String groupName) throws SchedulerException,
			ParseException {
		log.info("------- create Scheduling cronTrigger ----------------");
		CronTrigger cronTrigger =  new CronTrigger(triggerName, groupName, jobName, groupName, cronExp);
		return cronTrigger;
	}
	public static CronTrigger createCronTrigger(String cronExp,
			String jobName, String groupName) throws SchedulerException,
			ParseException {
		log.info("------- create Scheduling cronTrigger ----------------");
		CronTrigger cronTrigger =createCronTrigger(cronExp,"trigger"+jobName, jobName, groupName);
		return cronTrigger;
	}

	public static void startScheduler(Scheduler scheduler)
			throws SchedulerException, ParseException {
		log.info("------- Starting Scheduler ----------------");
		// start the scheduler
		// All of the jobs have been added to the scheduler, but none of the
		// jobs
		// will run until the scheduler has been started
		scheduler.start();
	}

	public static void stopScheduler(Scheduler scheduler, boolean aftercomplete)
			throws SchedulerException, ParseException {
		log.info("------- Shutting Down ---------------------");
		scheduler.shutdown(aftercomplete);// shutdown() does not return until
											// executing Jobs complete execution
		// //shutdown() returns immediately, but executing Jobs continue running
		// to completion
		// sched.shutdown(false);
		// sched.shutdown();

		log.info("------- Shutdown Complete -----------------");

		SchedulerMetaData metaData = scheduler.getMetaData();
		log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
	}

	public static void interruptScheduler(Scheduler scheduler,
			JobDetail jobDetail) throws SchedulerException, ParseException {
		log.info("------- interrupt Scheduler job---------------------");
		// tell the scheduler to interrupt our job
		scheduler.interrupt(jobDetail.getName(), jobDetail.getGroup());
	}

	public static void updateTrigger(Scheduler scheduler, String jobName,
			String groupName, String cronExp) throws SchedulerException,
			ParseException {
		log.info("------- update  Scheduler Trigger---------------------");
		Trigger newTrigger =new CronTrigger("trigger"+ jobName, groupName, jobName, groupName, cronExp);
		newTrigger.setJobName(jobName);
		newTrigger.setJobGroup(groupName);

		scheduler.rescheduleJob(jobName, groupName,newTrigger);
	}

	public static void updateJob(Scheduler scheduler, Class jobClass,
			String jobName, String groupName, Map params, String cronExp)
			throws SchedulerException, ParseException {
		log.info("------- update  Scheduler Job---------------------");
		// Add the new job to the scheduler, instructing it to "replace"
		// the existing job with the given name and group (if any)
		JobDetail job1 = createJob(jobClass, jobName, groupName, params);
		// store, and set overwrite flag to 'true'
		scheduler.addJob(job1, true);

	}

	public static Map<String,List<String>> listJobinScheduler(
			Scheduler scheduler) throws SchedulerException, ParseException {
		log.info("------- list  Scheduler Job---------------------");
		Map<String, List<String>> jobs = new HashMap<String, List<String>>();
		// enumerate each job group
		for (String group : scheduler.getJobGroupNames()) {
			// enumerate each job in group
			
			 List<String> keys=Arrays.asList(scheduler.getJobNames(group));
			jobs.put(group, keys);
			for (String jobKey : keys) {
				log.info(group+"Group Found job identified by: " + jobKey);
			}
		}

		return jobs;
	}
	public static void pauseTrigger(Scheduler scheduler, String jobName,String group)
			throws SchedulerException, ParseException {
		log.info("------- pauseTrigger  Scheduler Job---------------------");
		scheduler.pauseTrigger("trigger"+ jobName, group);//停止触发器
	}
	public static void resumeTrigger(Scheduler scheduler, String jobName,String group)
			throws SchedulerException, ParseException {
		log.info("------- resumeTrigger  Scheduler Job---------------------");
		scheduler.resumeTrigger("trigger"+ jobName, group);//重启触发器
	}
	public static boolean removeTrigdger(Scheduler scheduler,String jobName,String group)
			throws SchedulerException, ParseException {
		log.info("------- removeTrigdger  Scheduler Job---------------------");
		scheduler.pauseTrigger("trigger"+ jobName, group);//停止触发器
		return scheduler.unscheduleJob("trigger"+ jobName, group);//移除触发器
	}
	public static Map<String, List<String>> listTriggerinScheduler(
			Scheduler scheduler) throws SchedulerException, ParseException {
		log.info("------- list  Scheduler Trigger---------------------");
		Map<String, List<String>> triggers = new HashMap<String,List<String>>();
		// enumerate each job group
		for (String group : scheduler.getTriggerGroupNames()) {
			// enumerate each job in group
			 List<String> keys=Arrays.asList(scheduler.getTriggerNames(group));
			 triggers.put(group, keys);
			for (String jobKey : keys) {
				log.info(group+"Group Found Trigger identified by: " + jobKey);
			}
		}

		return triggers;
	}

	public static List<Trigger> listTriggerforJob(Scheduler scheduler,
			String jobName, String groupName) throws SchedulerException,
			ParseException {
		log.info("------- list  Scheduler Trigger---------------------");
		// enumerate each job group
		return Arrays.asList( scheduler.getTriggersOfJob(jobName,groupName));

	}
	public static boolean validCron(String cronExpression) throws SchedulerException,
			ParseException {
		log.info("------- validate cron ---------------------");
		return	CronExpression.isValidExpression(cronExpression);

	}
}
