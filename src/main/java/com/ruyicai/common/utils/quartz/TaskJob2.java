package com.ruyicai.common.utils.quartz;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.utils.Key;

/**
 * <p>
 * This is just a task job that execute task or send mail
 * </p>
 * 
 * @author tsj
 */
public class TaskJob2 implements Job {

	private static Logger _log = Logger.getLogger(TaskJob2.class);

	private String taskName;
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
	public TaskJob2() {
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// This job simply prints out its job name and the
		// date and time that it is running
		Key jobKey = context.getJobDetail().getKey();
		
		
		JobDataMap data = context.getJobDetail().getJobDataMap();
		Object ss=data.get("itcctScanTaskService");
		
		 _log.info("taskJob:" + jobKey + " executing at " + new Date()
			+ "\nsimpleService= "+ss );
		 if (data != null && data.size() > 0) {
			java.util.Iterator it = data.entrySet().iterator();
			while (it.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
				String key = (String) entry.getKey();
				Object s = entry.getValue();
               
				_log.info(key + "=key" + "value=" + s);
			}

		}
		
		// 1.执行任务
//		ItcctScanTask task=itcctScanTaskService.findItcctTaskByTaskName(taskName);
//		if(task==null){
//			_log.info("taskJob:" + jobKey  + " return null for query task by taskname=" +taskName);
//			return;
//		}
//		ItcctScanTaskClient client = new ItcctScanTaskClient();
//		String url = task.getScanners().getUrl();
//		String xml="";//task.getXml();
//		ItcctScanTaskWSCilentService iws = client.getServices(url);
//		String message="";
//		boolean success = true;
//		try {
//			if (client != null && iws != null) {
//				String res = client.addTask(iws, xml);
//				ItcctresultResponseParser response = Writer
//						.parseResultResponse(res);
//				task.setTaskId(response.getTaskId());
//				if ("1".equals(response.getResult())) {
//					message = "任务创建成功";
//					task.setStatus(1);
//				}
//				if ("2".equals(response.getResult())) {
//					message = response.getDescription();
//					task.setDescription(response.getDescription());
//					task.setStatus(2);
//				}
//				if ("null".equals(task
//								.getTaskId())) {
//					task.setTaskId(null);
//				}
//			}
//		} catch (Exception e) {
//			success = false;
//			message="扫描器调用失败";
//			task.setDescription("扫描器调用失败");
//			task.setStatus(2);
//			if ("null".equals(task.getTaskId())) {
//				task.setTaskId(null);
//			}
//		}
//		itcctScanTaskService.update(task);
//		// 2.获得任务的结果 .发送邮件
//		_log.info("taskJob:" + jobKey + " executed failed " + message);
		
	}

}
