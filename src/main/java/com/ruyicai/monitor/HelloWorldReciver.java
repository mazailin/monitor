package com.ruyicai.monitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ruyicai.monitor.jms.OrderRequest;

public class HelloWorldReciver
{

 public static void main(String args[]) 
 {
	 try{
//	 String text="{\"amt\":400,\"batchcode\":\"\",\"betRequests\":[{\"amt\":400,\"betcode\":\"502@20130314|4|301|30^20130314|4|302|0^\"}],\"bettype\":2,\"blessing\":\"\",\"buyuserno\":\"00000033\",\"caseLotRequest\":null,\"channel\":\"864\",\"desc\":\"\",\"lotmulti\":1,\"lotno\":\"J00005\",\"lotsType\":0,\"oneamount\":200,\"paytype\":1,\"prizeend\":1,\"reciverMobile\":\"\",\"subchannel\":\"00092493\",\"subscribeRequests\":[],\"userno\":\"00000033\"}";
//	 OrderRequest b= 	JSON.parseObject(text, OrderRequest.class);
//	 betRequests.toJavaObject(betRequests, BetRequest.class);
//	 OrderRequest a= 	 JsonUtil.fromJsonToObject(text, OrderRequest.class);
//	 System.out.println("=="+a.getBetRequests());
	   ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "com/ruyicai/monitor/applicationContext.xml" });
//  JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
//  Destination destination = (Destination) context.getBean("destination1");
//  System.out.println("will wait:" + jmsTemplate.getReceiveTimeout()+ " seconds for message");
//  TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
//  System.out.println("reviced msg is:" + msg.getText());
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 }

}

