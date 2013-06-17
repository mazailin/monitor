package com.ruyicai.monitor.jms;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class InnerMessageConverter implements MessageConverter {
	public InnerMessageConverter() {
	}

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		if (!(message instanceof ActiveMQMessage)) {
			throw new MessageConversionException(
					"Message isn't a ActiveMQTextMessage="+message.getClass());
		}
		ActiveMQMessage msg = (ActiveMQMessage) message;
		System.out.println("fromMessage="+msg);
		try {
			MessageDescription messageDescription = new MessageDescription();
			messageDescription.setCommandId(msg.getCommandId());
			messageDescription.setMessageId(msg.getMessageId());
			messageDescription.setBrokerInTime(msg.getBrokerInTime());
			messageDescription.setBrokerOutTime(msg.getBrokerOutTime());
			messageDescription.setDestination(msg.getDestination());
			messageDescription.setProducerId(msg.getProducerId());
			messageDescription.setProperties(msg.getProperties());
//			messageDescription.setText(msg.getContent().toString());
			messageDescription.setTimestamp(msg.getTimestamp());
			messageDescription.setTransactionId(msg.getTransactionId());
			return messageDescription;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		// if(!(object instanceof MessageDescription)){
		// throw new
		// MessageConversionException("Object isn't a MessageDescription");
		// }
		// MessageDescription messageDescription = (MessageDescription)object;
		// MapMessage message = session.createMapMessage();
		// message.setString("content", messageDescription.getContent());
		// message.setLong("createDate",
		// messageDescription.getCreateDate().getTime());
		// message.setShort("level", messageDescription.getLevel());
		// message.setString("toUserIds", messageDescription.getToUserIds());
		// message.setString("fromUserName",
		// messageDescription.getFromUserName());
		System.out.println("toMessage===" + object);
		MapMessage message = session.createMapMessage();
		return message;
	}
}
