package com.ruyicai.monitor;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class HelloWorldSender
{
 public static void main(String args[]) throws Exception
 {
  ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {  "com/ruyicai/monitor/applicationContext.xml"  });
  JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
  Destination destination = (Destination) context.getBean("destination");
  jmsTemplate.send
  (
   destination, new MessageCreator()
   {
    public Message createMessage(Session session) throws JMSException
    {
     return session.createTextMessage("大家好这个是测试！");
    }
   }
  );
 }

}

