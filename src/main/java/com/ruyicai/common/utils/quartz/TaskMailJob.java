package com.ruyicai.common.utils.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;

/**
 * <p>
 * This is just a task job that execute task or send mail
 * </p>
 * 
 * @author tsj
 */
public class TaskMailJob implements Runnable {

	private static Logger _log = Logger.getLogger(TaskMailJob.class);
	
	
//	private String taskName;
//	private String sendmail;// 逗号分隔的邮件地址
//	private String attach;
//	private String host;
//	private String from;
//	private String username;
//	private String password;



	/**
	 * <p>
	 * Empty constructor for job initilization
	 * </p>
	 * <p>
	 * Quartz requires a public empty constructor so that the scheduler can
	 * instantiate the class whenever it needs.
	 * </p>
	 */
	public TaskMailJob() {
	}


	/**
	 * <p>
	 * Called by the <code>{@link org.quartz.Scheduler}</code> when a
	 * <code>{@link org.quartz.Trigger}</code> fires that is associated with the
	 * <code>Job</code>.
	 * </p>
	 * 
	 * @throws JobExecutionException
	 *             if there is an exception while executing the job.
	 */
	@Override
	public void run() {
		// This job simply prints out its job name and the
		// date and time that it is running
	
	
	}
	
}
