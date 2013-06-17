package com.ruyicai.monitor.jms;

import javax.annotation.Resource;

import org.springframework.jms.support.converter.MessageConversionException;

import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.service.ITorderBeanService;
import com.ruyicai.monitor.thread.ThreadMain;

/**
 * jms:topic:ordercannelTopic
 * @author tian
 *
 */
public class TopicConsumerC {
	@Resource
	public ITorderBeanService instanceTorderBeanService;
	
	 public void receive(Object message) {   
		 if (!(message instanceof MessageDescription)) {
				throw new MessageConversionException(
						"Message isn't a MessageDescription");
			}
		 MessageDescription msg=(MessageDescription)message;
		 //orderbetTopic,orderAfterBetTopic
		 System.out.println("****ordercannelTopic Topic C : " + msg.getText());
		 synchronized(this){
		 Torder torder = JsonUtil.fromJsonToObject(msg.getText(), Torder.class);
		 Torder o= ThreadMain.get(torder.getId());
		 if(o==null){
			
			 ThreadMain.put(torder.getId(), torder);
		 }else{
			 ThreadMain.remove(torder.getId());
		 }
		 torder.setFlagvalue(3);
		 instanceTorderBeanService.save(torder);
		 }
		
	 }	 
}
