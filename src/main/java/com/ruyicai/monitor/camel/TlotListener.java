package com.ruyicai.monitor.camel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.jms.Torder;
import com.ruyicai.monitor.service.ITorderBeanService;
import com.ruyicai.monitor.thread.ThreadMain;

@Component
public class TlotListener {
	private Logger logger = Logger.getLogger(TlotListener.class);
	@Produce(uri = "jms:topic:orderbetTopic")
	private ProducerTemplate orderbetProducer;
	@Resource
	public ITorderBeanService instanceTorderBeanService;
	
	 private Torder gettorder(String orderid){
		 try {
			 CCSProps sp = Props.instance().getServProps();
			String serverurl = sp.get("getTorderserverurl");
//				String serverurl = "http://192.168.0.42:8080/lottery/select/getTorder";
				List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair("orderid",orderid));
				String res1=HttpUtil.sendRequestGetStr(serverurl,nameValuePair,false);
				JSONObject aa=JSON.parseObject(res1);
				JSONObject oo=aa.getJSONObject("value");
					Torder torder = JsonUtil.fromJsonToObject(oo.toJSONString(), Torder.class);
//					System.out.println("torder=="+torder.toString(ToStringStyle.DEFAULT_STYLE));
					return torder;
			} catch (CCSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	 }
		public void sendOrderbetJMS(final String orderid, final String buyuserno) {
			try {
				Map<String, Object> header = new HashMap<String, Object>();
				header.put("orderid", orderid);
				header.put("buyuserno", buyuserno);
				orderbetProducer.sendBodyAndHeaders(null, header);
			} catch (Exception e) {
				logger.error("发送订单投注进入队列出错, orderid:" + orderid, e);
			}
		}
	/**
	 * 订单请求
	 * @param orderid
	 * @param lotno
	 * @param batchcode
	 * @param body
	 */
	@Consume(uri="jms:topic:orderbetTopic")
	public void orderbetTopic(@Header("orderid") String orderid,@Header("lotno") String lotno,	@Header("batchcode") String batchcode
			,@Body String body){
		 logger.debug("jms:topic:orderbetTopic orderid="+orderid+" lotno="+lotno+" batchcode="+batchcode+" body="+body);
		 Torder	to=null;
//		 synchronized(this){
			Torder o= ThreadMain.get(orderid);
			 if(o==null){	
				 to=gettorder(orderid);
				 if(to==null){
					 logger.info("get gettorder null");
						return;
					}
				 to.setId(orderid);
				 to.setLotno(lotno);
				 ThreadMain.put(to.getId(), to);
				
				
	 		}else{
	 			 logger.debug("收到重复的消息，暂不处理忽略");
	 			return;
		    //TODO 收到重复的消息，暂不处理忽略
	         }
//			}
		      to.setFlagvalue(1);
			 instanceTorderBeanService.save(to);
	}
	/**
	 * 订单出票成功
	 * @param lotno
	 * @param batchcode
	 * @param body
	 */
	@Consume(uri="jms:topic:orderAfterBetTopic")
	public void orderAfterBetTopic(@Header("lotno") String lotno,	@Header("batchcode") String batchcode
			,@Body String body){
		 logger.debug("jms:topic:orderAfterBetTopic lotno="+lotno+" batchcode="+batchcode+" body="+body);
//		synchronized(this){
			 Torder torder = JsonUtil.fromJsonToObject(body, Torder.class);
			 Torder o= ThreadMain.get(torder.getId());
			 if(o==null){
				return;
//				 ThreadMain.put(torder.getId(), torder);
			 }else{
				 ThreadMain.remove(torder.getId());
			 }
			 torder.setFlagvalue(2);
			 instanceTorderBeanService.save(torder);
//			 }
	}
	/**
	 * 订单取消
	 * @param lotno
	 * @param batchcode
	 * @param body
	 */
	@Consume(uri="jms:topic:ordercannelTopic")
	public void ordercannelTopic(@Header("lotno") String lotno,	@Header("batchcode") String batchcode
			,@Body String body){
		 logger.debug("jms:topic:ordercannelTopic lotno="+lotno+" batchcode="+batchcode+" body="+body);
//		 synchronized(this){
			 Torder torder = JsonUtil.fromJsonToObject(body, Torder.class);
			 Torder o= ThreadMain.get(torder.getId());
			 if(o==null){
				
				 ThreadMain.put(torder.getId(), torder);
			 }else{
				 ThreadMain.remove(torder.getId());
//			 }
			 torder.setFlagvalue(3);
			 instanceTorderBeanService.save(torder);
			 }
	}

	
}
