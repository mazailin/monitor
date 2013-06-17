package com.ruyicai.common.utils.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:perseus-quartz-servlet.xml"}) 

public class SimpleServiceTest {
	
	@Resource
	private SchedulerService schedulerService;
	
	
	
	@Test
	public void test(){
//		//执行业务逻辑...
//		
//		//设置高度任务
//		//每10秒中执行调试一次
//		schedulerService.schedule("0/10 * * ? * * *"); 
//		
//		Date startTime = this.parse("2009-06-01 21:50:00");
//		Date endTime =  this.parse("2009-06-01 21:55:00");
//        
//		//2009-06-01 21:50:00开始执行调度
//		schedulerService.schedule(startTime);
//
//		//2009-06-01 21:50:00开始执行调度，2009-06-01 21:55:00结束执行调试
//		schedulerService.schedule(startTime,endTime);
//		
//		//2009-06-01 21:50:00开始执行调度，执行5次结束
//		schedulerService.schedule(startTime,null,5);
//
//		//2009-06-01 21:50:00开始执行调度，每隔20秒执行一次，执行5次结束
//		schedulerService.schedule(startTime,null,5,20);
//		
//		//等等，查看com.sundoctor.quartz.service.SchedulerService
		
		Map params=new HashMap();
    	params.put("taskName", "testtaskid");
    	params.put("sendmail", "tianshangjun@eversec.com.cn");
//    	params.put("itcctScanTaskService", itcctScanTaskService);
    	String cron="0/30 * * * * ?";
    	if(schedulerService.validCron(cron)){
    	schedulerService.addJobTrigger(TaskJob2.class, cron, "testjob", "testgroup", params);
        schedulerService.startScheduler(); 
    	}
        for(int i=0; i < 5; i++) {
        try {
            Thread.sleep(7000L); 
          
        } catch (Exception e) {
        }
      
    }
//        schedulerService.addJobTrigger(TaskJob2.class, "0/20 * * * * ?", "testjob2", "testgroup", params);
//        schedulerService.startScheduler(); 
        for(int i=0; i < 50; i++) {
            try {
                Thread.sleep(7000L); 
              
            } catch (Exception e) {
            }
          
        }
	}
	@Test
	public void testSchedulerService(){
		String cron="0 0 16 16 11 ? 2011";
		System.out.println(schedulerService.validCron(cron));
		//trigger.setStartTime(new Date(System.currentTimeMillis()+60*1000));
		//System.out.println(d+""+trigger.getFireTimeAfter(d)+"trigger getNextFireTime="+trigger.getStartTime());
	}
	@Test
	public void inittasktrigger(){
		
	       
	       for(int i=0; i < 50; i++) {
	            try {
	                Thread.sleep(7000L); 
	              
	            } catch (Exception e) {
	            }
	          
	        }
	}
	
	@Test
	public void testItcctScanTaskDao(){
//		List<ItcctScanTaskMail> l=itcctScanTaskDao.findTaskSysMail("asdfghh");
//		for(ItcctScanTaskMail a :l)
//			System.out.println("System.out.println mail="+a.getMail());
//	
		
				  for(int i=0; i < 50; i++) {
			            try {
			                Thread.sleep(7000L); 
			              
			            } catch (Exception e) {
			            }
			          
			        }
	}
	@Test
	public void testDate(){
		
	}
	private Date parse(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
