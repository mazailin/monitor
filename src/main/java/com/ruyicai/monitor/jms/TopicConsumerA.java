package com.ruyicai.monitor.jms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.jms.support.converter.MessageConversionException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.service.ITorderBeanService;
import com.ruyicai.monitor.thread.ThreadMain;
/**
 * jms:topic:orderbetTopic 
 * @author tian
 *
 */
public class TopicConsumerA {
//	@Resource
//	public ITorderBeanService instanceTorderBeanService;
	
	 public void receive(Object message) {   
		 if (!(message instanceof MessageDescription)) {
				throw new MessageConversionException(
						"Message isn't a MessageDescription");
			}
		 try{
		 MessageDescription msg=(MessageDescription)message;
		 //orderbetTopic,orderAfterBetTopic		 
		
//		 OrderRequest orderRequest = JsonUtil.fromJsonToObject(msg.getText(), OrderRequest.class);
		Map<String, Object> prop= msg.getProperties();    
		System.out.println("**** orderbetTopic Topic A : "+prop);
		 if(prop!=null){
			 Torder	to=null;
			 synchronized(this){
//		        String lotno = (String) prop.get("lotno");
				String orderid = (String)prop.get("orderid");
//				String buyuserno = (String) prop.get("buyuserno");
//				orderRequest.setLotno(lotno);
//				orderRequest.setOrderid(orderid);
//				orderRequest.setBuyuserno(buyuserno);
				Torder o= ThreadMain.get(orderid);
				 if(o==null){	
					// to=gettorder(orderid);
					 if(to==null){
							System.out.println("get gettorder null");
							return;
						}
					 ThreadMain.put(to.getId(), to);
					
					
		 		}else{
		 			return;
			    //TODO 收到重复的消息，暂不处理忽略
		         }
				}
			      to.setFlagvalue(1);System.out.println("**** orderbetTopic Topic A to=: "+to);
//				 instanceTorderBeanService.save(to);
		 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		}  
	 
	 private Torder gettorder(String orderid){
		 try {
			 CCSProps sp = Props.instance().getServProps();
			String serverurl = sp.get("getTorderserverurl");
//				String serverurl = "http://192.168.0.42:8080/lottery/select/getTorder";
				List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair("orderid",orderid));
				String res1=HttpUtil.sendRequestGetStr(serverurl,nameValuePair,false);
//				System.out.println(res1);
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
}
