package com.ruyicai.monitor.jms;

import java.util.Map;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.MessageId;
import org.apache.activemq.command.ProducerId;
import org.apache.activemq.command.TransactionId;

public class MessageDescription {
	private int commandId;
	private MessageId  messageId;
	private ProducerId producerId;
	private ActiveMQDestination destination;
	private TransactionId  transactionId;
	private long timestamp;
	private long brokerInTime;
	private long brokerOutTime;
	private Map<String, Object> properties;
	private String text;
	public int getCommandId() {
		return commandId;
	}
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	public MessageId  getMessageId() {
		return messageId;
	}
	public void setMessageId(MessageId  messageId) {
		this.messageId = messageId;
	}
	public ProducerId getProducerId() {
		return producerId;
	}
	public void setProducerId(ProducerId producerId) {
		this.producerId = producerId;
	}
	public ActiveMQDestination getDestination() {
		return destination;
	}
	public void setDestination(ActiveMQDestination destination) {
		this.destination = destination;
	}
	public TransactionId  getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(TransactionId  transactionId) {
		this.transactionId = transactionId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public long getBrokerInTime() {
		return brokerInTime;
	}
	public void setBrokerInTime(long brokerInTime) {
		this.brokerInTime = brokerInTime;
	}
	public long getBrokerOutTime() {
		return brokerOutTime;
	}
	public void setBrokerOutTime(long brokerOutTime) {
		this.brokerOutTime = brokerOutTime;
	}
	public Map<String, Object>  getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object>  properties) {
		this.properties = properties;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
