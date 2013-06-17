package com.ruyicai.common.utils.quartz;

import java.util.Map;

public interface SchedulerService {
	void addJobTrigger(Class jobClass, String cronExp, String jobName,
			String groupName, Map params);

	void startScheduler();
	public void stopScheduler();
	/**
	 * 根据名称和组别暂停Tigger
	 * 
	 * @param triggerName
	 * @param group
	 */
	void pauseTrigger(String triggerName, String group);

	/**
	 * 恢复Trigger
	 * 
	 * @param triggerName
	 * @param group
	 */
	void resumeTrigger(String triggerName, String group);

	/**
	 * 删除Trigger
	 * 
	 * @param triggerName
	 * @param group
	 */
	boolean removeTriggger(String triggerName, String group);
    boolean validCron(String cronExpression);
}
