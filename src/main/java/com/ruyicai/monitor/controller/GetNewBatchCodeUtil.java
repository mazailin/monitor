package com.ruyicai.monitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.jms.Torder;

public class GetNewBatchCodeUtil {
	String[] hfllotno = { "T01007", "T01010", "T01012", "T01014", "T01015" };
	String[] dllotno = { "F47104", "F47103", "F47102", "T01001", "T01002",
			"T01011", "T01009", "T01013", "T01003", "T01004", "T01005",
			"T01006" };
	String[] kbllotno = { "J00001", "J00002", "J00003", "J00004", "J00005",
			"J00006", "J00007", "J00008", "J00009", "J00010", "J00011",
			"J00012" };
	// --高频
	// 'T01007','T01010','T01012','T01014','T01015
	// --大盘
	// 'F47104','F47103','F47102','T01001','T01002','T01011','T01009','T01013','T01003','T01004','T01005','T01006')
	// --竞彩：
	// 'J00001','J00002','J00003','J00004','J00005','J00006','J00007','J00008','J00009','J00010','J00011','J00012')
	private Map<String, String> hflbatccode = new HashMap<String, String>(10);
	private Map<String, String> dlbatccode = new HashMap<String, String>();
	private Map<String, String> kblbatccode = new HashMap<String, String>(8);

	private void getbatchcode() {
		CCSProps sp = Props.instance().getServProps();
		String serverurl = sp.get("serverurl");
		for (String key : hfllotno) {
			String batchcode = getlotnoBatchcode(serverurl,key);
			hflbatccode.put(key, batchcode);
		}
		for (String key : dllotno) {
			String batchcode = getlotnoBatchcode(serverurl,key);
			hflbatccode.put(key, batchcode);
		}
		for (String key : kbllotno) {
			String batchcode = getlotnoBatchcode(serverurl,key);
			hflbatccode.put(key, batchcode);
		}

	}

	private String getlotnoBatchcode(String serverurl,String lotno) {
		try {
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair("lotno",lotno));
			nameValuePair.add(new BasicNameValuePair("num","1"));
			String res1=HttpUtil.sendRequestGetStr(serverurl,nameValuePair,false);
			JSONObject aa=JSON.parseObject(res1);
			JSONArray ja=aa.getJSONArray("value");
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<ja.size();i++){//('2013027','2013025')
			JSONObject oo=ja.getJSONObject(i);
			JSONObject ids=oo.getJSONObject("id");
			String batchcode=ids.getString("batchcode");
//			String lotno=ids.getString("lotno");
			String winbasecode=oo.getString("winbasecode");
			String winspecialcode=oo.getString("winspecialcode");
			}
			} catch (CCSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
	}
	/**
	 * 订单查询
	 * 
	 * @param orderid
	 * @return getTorder
	 */
//	public static void main(String[] args) {
//		try {
//		String serverurl = "http://192.168.0.42:8080/lottery/select/getTorder";
//		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
//		nameValuePair.add(new BasicNameValuePair("orderid","TE2013032200485003"));
//		String res1=HttpUtil.sendRequestGetStr(serverurl,nameValuePair,false);
//		System.out.println(res1);
//		JSONObject aa=JSON.parseObject(res1);
//		JSONObject oo=aa.getJSONObject("value");
//			Torder torder = JsonUtil.fromJsonToObject(oo.toJSONString(), Torder.class);
//			System.out.println("torder=="+torder.toString(ToStringStyle.DEFAULT_STYLE));
//			return;
//		
//	} catch (CCSException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}
}
