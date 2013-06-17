package com.ruyicai.monitor.camel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.jms.Torder;
import com.ruyicai.monitor.service.ITorderBeanService;
@Service("tOrderCheckService")
public class TOrderCheckService {
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	public ITorderBeanService instanceTorderBeanService;
	private List<String> orderids = new ArrayList<String>();

	//@Scheduled(cron="0 59 23 * * ? ")
	public void check() {
		long start=System.currentTimeMillis();
		try {
			logger.debug("check torder status start..."+start);
			// 1.check the 0 state order
			List<TorderBeanShow> tbshfl = new ArrayList<TorderBeanShow>();// 状态是0
																			// ，期结时间已到期
			// List<TorderBeanShow> wwww=new ArrayList<TorderBeanShow>();//状态是0
			// ，期结时间已到期
			tbshfl = instanceTorderBeanService.findTorderExperiod(null, 20);
             int i=0;
			// 2.
			for (TorderBeanShow s : tbshfl) {
				String res1 = gettorder4Oracle(s.getId());
				if(res1==null)continue;
				JSONObject aa = JSON.parseObject(res1);
				JSONObject oo = aa.getJSONObject("value");
				if(oo==null)continue;
				Torder torder = JsonUtil.fromJsonToObject(oo.toJSONString(),
						Torder.class);
				if (res1 == null || torder == null) {
					continue;
				}
//				if (s.getOrderstate().equals(torder.getOrderstate())) {
//					orderids.add(torder.getId());
//					continue;
//				} else {
//					if (!orderids.contains(torder.getId())) {
						s.setTorder(torder);
						// wwww.add(s);
						i++;
						torder.setFlagvalue(torder.getFlagvalue()+10);
						instanceTorderBeanService.save(torder);
//					}
//				}
			}
			
			logger.debug((System.currentTimeMillis()-start)+"check torder status finished update order size="+i+"orderids size="+orderids.size());
		} catch (CCSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String gettorder4Oracle(String orderid) throws CCSException {
		CCSProps sp = Props.instance().getServProps();
		String serverurl = sp.get("getTorderserverurl");
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("orderid", orderid));
		String res1 = HttpUtil.sendRequestGetStr(serverurl, nameValuePair,
				false);
		return res1;
	}
}
