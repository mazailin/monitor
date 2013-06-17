

package com.ruyicai.monitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.controller.BaseController;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.ServerInitConfigUtil;
import com.ruyicai.common.utils.Utils;
import com.ruyicai.common.utils.date.DateUtils;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.common.vo.BaseConditionVO;
import com.ruyicai.monitor.JsonUtil;
import com.ruyicai.monitor.domain.TorderBean;
import com.ruyicai.monitor.domainshow.MonitorShow;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;
import com.ruyicai.monitor.jms.Torder;
import com.ruyicai.monitor.service.ITorderBeanService;


/**
 * @author tianshangjun
 */
  @Controller
 @RequestMapping("/torder/*")
public class TorderController  extends BaseController {
    @Resource
	public ITorderBeanService instanceTorderBeanService;
	
	 //---------------------add--------------------------------------
     @RequestMapping(value="add", method = RequestMethod.GET)
    public String  addTorderBean(Model model) {
         //model.addAttribute("roleList", roleList);
	 return "/func/torder/add";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(TorderBean torder) {
		try {
			instanceTorderBeanService.save(torder);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	 //---------------------edit--------------------------------------
	@RequestMapping(value ="/edit/{torderId}", method = RequestMethod.GET)
	public String edit(@PathVariable("torderId") String torderId, Model model) {
		TorderBean  torder = instanceTorderBeanService.findByKey(torderId);

		model.addAttribute("vo", torder);

		return "/func/torder/edit";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(TorderBean  torder) {
	try {
		TorderBean torderold = instanceTorderBeanService.findByKey(torder.getId()+"");
               	     	torderold.setMemo(torder.getMemo());
			     	torderold.setBatchcode(torder.getBatchcode());
			     	torderold.setLotno(torder.getLotno());
			     	torderold.setAmt(torder.getAmt());
			     	torderold.setPaytype(torder.getPaytype());
			     	torderold.setOrderstate(torder.getOrderstate());
			     	torderold.setBettype(torder.getBettype());
			     	torderold.setPrizestate(torder.getPrizestate());
			     	torderold.setOrderprizeamt(torder.getOrderprizeamt());
			     	torderold.setWinbasecode(torder.getWinbasecode());
			     	torderold.setOrdertype(torder.getOrdertype());
			     	torderold.setTsubscribeflowno(torder.getTsubscribeflowno());
			     	torderold.setTlotcaseid(torder.getTlotcaseid());
			     	torderold.setCreatetime(torder.getCreatetime());
			     	torderold.setUserno(torder.getUserno());
			     	torderold.setBuyuserno(torder.getBuyuserno());
			     	torderold.setSubaccount(torder.getSubaccount());
			     	torderold.setBetnum(torder.getBetnum());
			     	torderold.setCanceltime(torder.getCanceltime());
			     	torderold.setEndtime(torder.getEndtime());
			     	torderold.setOdesc(torder.getOdesc());
			     	torderold.setBetcode(torder.getBetcode());
			     	torderold.setAlreadytrans(torder.getAlreadytrans());
			     	torderold.setLotstype(torder.getLotstype());
			     	torderold.setLotmulti(torder.getLotmulti());
			     	torderold.setPrizeinfo(torder.getPrizeinfo());
			     	torderold.setHasachievement(torder.getHasachievement());
			     	torderold.setOrderpreprizeamt(torder.getOrderpreprizeamt());
			     	torderold.setOrderinfo(torder.getOrderinfo());
			     	torderold.setBody(torder.getBody());
			     	torderold.setInstate(torder.getInstate());
			     	torderold.setPaystate(torder.getPaystate());
			     	torderold.setEncashtime(torder.getEncashtime());
			     	torderold.setEventcode(torder.getEventcode());
			     	torderold.setChannel(torder.getChannel());
			     	torderold.setSubchannel(torder.getSubchannel());
			     	torderold.setAgencyno(torder.getAgencyno());
			     	torderold.setPlaytype(torder.getPlaytype());
			     	torderold.setLatedteamid(torder.getLatedteamid());
			     	torderold.setLastprinttime(torder.getLastprinttime());
			     			instanceTorderBeanService.update(torder);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
   //---------------------delete--------------------------------------
   @RequestMapping(value = "/delete/{torderId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("torderId") int torderId) {
             try {
		instanceTorderBeanService.deleteByIds("("+torderId+")");
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
   
   @RequestMapping(value = "/check", method = RequestMethod.GET)
 	public String check(BaseConditionVO vo,          @RequestParam(required = false)  String orderid,      		
Model model) {
	   try {
		   //1.check the 0 state order 
		   List<TorderBeanShow> tbshfl=new ArrayList<TorderBeanShow>();//状态是0 ，期结时间已到期
		   List<TorderBeanShow> wwww=new ArrayList<TorderBeanShow>();//状态是0 ，期结时间已到期
		   List<TorderBeanShow> left=new ArrayList<TorderBeanShow>();//状态是0 ，期结时间已到期
		   tbshfl= instanceTorderBeanService.findTorderExperiod( orderid,10);
		   
		   //2.
		   for(TorderBeanShow s:tbshfl){
			   String  res1=gettorder4Oracle(s.getId());
			   if(res1==null)continue;
				JSONObject aa=JSON.parseObject(res1);
				JSONObject oo=aa.getJSONObject("value");
				if(oo==null)continue;
				Torder torder = JsonUtil.fromJsonToObject(oo.toJSONString(), Torder.class);
				if(res1==null||torder==null){
					left.add(s);
					continue;
				}
//				if(s.getOrderstate().equals(torder.getOrderstate())){
//					continue;
//				}else{
					
					wwww.add(s);
					torder.setFlagvalue(torder.getFlagvalue()+10);
					s.setTorder(torder);
					 instanceTorderBeanService.save(torder);
//				}
		   }
		   model.addAttribute("torderList", wwww);
		   model.addAttribute("torderListleft", left);
	   return "/func/torder/check";
	} catch (CCSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
   }
   private String gettorder4Oracle(String orderid)throws CCSException{
	   CCSProps sp = Props.instance().getServProps();
		String serverurl = sp.get("getTorderserverurl");
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair("orderid",orderid));
			String res1=HttpUtil.sendRequestGetStr(serverurl,nameValuePair,false);
			return res1;
   }
   //---------------------list--------------------------------------
   @RequestMapping(value = "/listo", method = RequestMethod.GET)
  	public String listo(  @RequestParam(required = false)  String orderid,      		Model model) {
			 try {
				String  res1=gettorder4Oracle(orderid);
				//	JSONObject aa=JSON.parseObject(res1);
					//JSONObject oo=aa.getJSONObject("value");
						//Torder torder = JsonUtil.fromJsonToObject(oo.toJSONString(), Torder.class);
//						System.out.println("torder=="+torder.toString(ToStringStyle.DEFAULT_STYLE));
						//return torder;
					 model.addAttribute("vo", res1);
					 return "/func/torder/listori";
				} catch (CCSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
  	}
   @RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list2(BaseConditionVO vo, Model model) {
		return list(vo, model,null);
	}
   @RequestMapping(value = "/monitorlist", method = RequestMethod.GET)
	public String monitorlist(BaseConditionVO vo, Model model) {
		return monitor(vo, model);
	}
// //1
//   时时彩 T01007
//   多乐彩T01010
//   十一运夺金 T01012
//   广东十一选五T01014
//   广东快乐十分T01015
//2
//   大盘：
//   双色球F47104
//   福彩3D F47103
//   七乐彩F47102
//   大乐透T01001
//   排列三T01002
//   排列五T01011
//   七星彩T01009
//   22选5 T01013
//   足彩胜负彩T01003
//   足彩任九场T01004
//   足彩进球彩T01005
//   足彩半全场T01006
//3
//   竞彩：
//   J00001 足球让球胜平负
//   J00002 足球比分
//   J00003 足球总进球
//   J00004 半全场
//
//   J00005 篮球胜负
//   J00006 篮球让分胜负
//   J00007 胜分差
//   J00008 篮球大小分
//
//   J00009 冠军（自己还没卖）
//   J00010 冠亚军（自己还没卖）
//
//   J00011 足球混合投注
//   J00012 篮球混合投注
   @RequestMapping(value = "/monitor", method = RequestMethod.POST)
	public String monitor(BaseConditionVO vo, Model model){
	
		  List<MonitorShow> monitorShowList=new ArrayList<MonitorShow>();
			try{
		 List<TorderCountShow> tcs= instanceTorderBeanService.findTorderCountShow(null,(vo.getPageNum()-1)*vo.getNumPerPage(),vo.getNumPerPage());
		 int hflc=0,dl=0,kbl=0,max=0;
		 for(TorderCountShow ms:tcs){
			 switch(ms.getType()){
			 case 1:hflc=ms.getNumber();break;
			 case 2:dl=ms.getNumber();break;
			 case 3:kbl=ms.getNumber();break;
			 }
		 }
		 if(hflc>max)max=hflc;
		 if(dl>max)max=dl;
		 if(kbl>max)max=kbl;
		 vo.setTotalCount(max);	
		 //TODO 改成查询三次
		 
		 List<TorderBeanShow> tbshfl=new ArrayList<TorderBeanShow>();
		 List<TorderBeanShow> tbsdl=new ArrayList<TorderBeanShow>();
		 List<TorderBeanShow> tbskbl= new ArrayList<TorderBeanShow>();
		 Map param=new HashMap();
		 param.put("type", 1);
		if(hflc>0)tbshfl= instanceTorderBeanService.findTorderBeanShow(param,(vo.getPageNum()-1)*vo.getNumPerPage(),vo.getNumPerPage());
		 param.put("type", 2);
		if(dl>0)tbsdl= instanceTorderBeanService.findTorderBeanShow(param,(vo.getPageNum()-1)*vo.getNumPerPage(),vo.getNumPerPage());
		 param.put("type", 3);
		if(kbl>0)tbskbl= instanceTorderBeanService.findTorderBeanShow(param,(vo.getPageNum()-1)*vo.getNumPerPage(),vo.getNumPerPage());
        int m=tbshfl.size(),n=tbsdl.size(),o=tbskbl.size(),l=0;
        if(m>l)l=m;
		 if(n>l)l=n;
		 if(o>l)l=o;
//		 vo.setTotalCount(l);	
           for(int i=0;i<l;i++){
        	   MonitorShow ms=new MonitorShow();
        	  if(i<m){
        		  TorderBeanShow tb=tbshfl.get(i);
        		  String res=DateUtils.getTimedifference(DateUtils.getNow(), tb.getLastprinttime());
//             		if(res.contains("已过期"))continue;
        		 
        		  ms.setHflid(tb.getId());
        		  ms.setHfllotno(tb.getLotno());
        		  ms.setHflbatchcode(tb.getBatchcode());
           		  ms.setHflcreatetime(DateUtils.defaultDateFormat(tb.getCreatetime()));
           		 
         		  ms.setHflremainingtime(res);
         		
        	  }
        	  if(i<n){
        		  TorderBeanShow tb=tbsdl.get(i);
        		  String res=DateUtils.getTimedifference(DateUtils.getNow(), tb.getLastprinttime());
//             		if(res.contains("已过期"))continue;
        		
        		  ms.setDlid(tb.getId());
        		  ms.setDllotno(tb.getLotno());
        		  ms.setDlbatchcode(tb.getBatchcode());
       			 ms.setDlcreatetime(DateUtils.defaultDateFormat(tb.getCreatetime()));
       			 ms.setDlremainingtime(res);
       			
        	  }
        	  if(i<o){
        		  TorderBeanShow tb=tbskbl.get(i);
        		  String res=DateUtils.getTimedifference(DateUtils.getNow(), tb.getLastprinttime());
//             		if(res.contains("已过期"))continue;
        		  
        		  ms.setKblid(tb.getId());
        		  ms.setKbllotno(tb.getLotno());
        		  ms.setKblbatchcode(tb.getBatchcode());
       			 ms.setKblcreatetime(DateUtils.defaultDateFormat(tb.getCreatetime()));
       			 ms.setKblremainingtime(res);
       			   
        	  }
        	  monitorShowList.add(ms);
           }
           logger.debug("va total ="+vo.getTotalCount()+" monitorShowList size="+monitorShowList.size());
		}catch(Exception e){
			logger.debug("monitor exception ",e);
		}
		 model.addAttribute("pageTitle",ServerInitConfigUtil.pageTitle);
		 model.addAttribute("loginUserName","admin");
		 model.addAttribute("vo", vo);	
		 model.addAttribute("monitorShowList", monitorShowList);
		 return "/func/torder/monitor";
   }
		@RequestMapping(value = "/listTorderBean", method = RequestMethod.POST)
	public String list(BaseConditionVO vo, Model model,
	 		
        // @RequestParam(required = false)  String id,      		
//         @RequestParam(required = false)  String endbatchcode,      		
//         @RequestParam(required = false)  String startbatchcode,      		
         @RequestParam(required = false)  String lotno      		
        // @RequestParam(required = false)  String amt,      		
        // @RequestParam(required = false)  Integer paytype,      		
        // @RequestParam(required = false)  Integer orderstate,      		
        // @RequestParam(required = false)  String bettype,      		
        // @RequestParam(required = false)  Integer prizestate,      		
        // @RequestParam(required = false)  Long orderprizeamt,      		
        // @RequestParam(required = false)  String winbasecode,      		
        // @RequestParam(required = false)  Integer ordertype,      		
        // @RequestParam(required = false)  String tsubscribeflowno,      		
        // @RequestParam(required = false)  String tlotcaseid,      		
        // @RequestParam(required = false)  java.util.Date createtime,      		
        // @RequestParam(required = false)  String userno,      		
        // @RequestParam(required = false)  String buyuserno,      		
        // @RequestParam(required = false)  String subaccount,      		
        // @RequestParam(required = false)  Integer betnum,      		
        // @RequestParam(required = false)  java.util.Date canceltime,      		
        // @RequestParam(required = false)  java.util.Date endtime,      		
        // @RequestParam(required = false)  String odesc,      		
        // @RequestParam(required = false)  String betcode,      		
        // @RequestParam(required = false)  Integer alreadytrans,      		
        // @RequestParam(required = false)  Integer lotstype,      		
        // @RequestParam(required = false)  Integer lotmulti,      		
        // @RequestParam(required = false)  String prizeinfo,      		
        // @RequestParam(required = false)  Integer hasachievement,      		
        // @RequestParam(required = false)  Long orderpreprizeamt,      		
        // @RequestParam(required = false)  String orderinfo,      		
        // @RequestParam(required = false)  String body,      		
        // @RequestParam(required = false)  Integer instate,      		
        // @RequestParam(required = false)  Integer paystate,      		
        // @RequestParam(required = false)  java.util.Date encashtime,      		
        // @RequestParam(required = false)  String eventcode,      		
        // @RequestParam(required = false)  String channel,      		
        // @RequestParam(required = false)  String subchannel,      		
        // @RequestParam(required = false)  String agencyno,      		
        // @RequestParam(required = false)  String playtype,      		
        // @RequestParam(required = false)  String latedteamid            
	) {
		long total = 0;
				
		  Map param=new HashMap();
            List<TorderBean> list=new ArrayList<TorderBean>();
        
	  try{
             
		//  if(!Util.strIsNull(id))param.put("id", id);
             
		//  if(!Util.strIsNull(memo))param.put("memo", memo);
             
		  if (!Utils.strIsNull(vo.getStartDate()))
				param.put(Contants.FIELD_STARTDATE, vo.getStartDate());
			if (!Utils.strIsNull(vo.getEndDate()))
				param.put(Contants.FIELD_ENDDATE, vo.getEndDate());
			if(!Utils.strIsNull(lotno))param.put("lotno", lotno);
             
		//  if(!Util.strIsNull(amt))param.put("amt", amt);
             
		//  if(!Util.strIsNull(paytype))param.put("paytype", paytype);
             
		//  if(!Util.strIsNull(orderstate))param.put("orderstate", orderstate);
             
		//  if(!Util.strIsNull(bettype))param.put("bettype", bettype);
             
		//  if(!Util.strIsNull(prizestate))param.put("prizestate", prizestate);
             
		//  if(!Util.strIsNull(orderprizeamt))param.put("orderprizeamt", orderprizeamt);
             
		//  if(!Util.strIsNull(winbasecode))param.put("winbasecode", winbasecode);
             
		//  if(!Util.strIsNull(ordertype))param.put("ordertype", ordertype);
             
		//  if(!Util.strIsNull(tsubscribeflowno))param.put("tsubscribeflowno", tsubscribeflowno);
             
		//  if(!Util.strIsNull(tlotcaseid))param.put("tlotcaseid", tlotcaseid);
             
		//  if(!Util.strIsNull(createtime))param.put("createtime", createtime);
             
		//  if(!Util.strIsNull(userno))param.put("userno", userno);
             
		//  if(!Util.strIsNull(buyuserno))param.put("buyuserno", buyuserno);
             
		//  if(!Util.strIsNull(subaccount))param.put("subaccount", subaccount);
             
		//  if(!Util.strIsNull(betnum))param.put("betnum", betnum);
             
		//  if(!Util.strIsNull(canceltime))param.put("canceltime", canceltime);
             
		//  if(!Util.strIsNull(endtime))param.put("endtime", endtime);
             
		//  if(!Util.strIsNull(odesc))param.put("odesc", odesc);
             
		//  if(!Util.strIsNull(betcode))param.put("betcode", betcode);
             
		//  if(!Util.strIsNull(alreadytrans))param.put("alreadytrans", alreadytrans);
             
		//  if(!Util.strIsNull(lotstype))param.put("lotstype", lotstype);
             
		//  if(!Util.strIsNull(lotmulti))param.put("lotmulti", lotmulti);
             
		//  if(!Util.strIsNull(prizeinfo))param.put("prizeinfo", prizeinfo);
             
		//  if(!Util.strIsNull(hasachievement))param.put("hasachievement", hasachievement);
             
		//  if(!Util.strIsNull(orderpreprizeamt))param.put("orderpreprizeamt", orderpreprizeamt);
             
		//  if(!Util.strIsNull(orderinfo))param.put("orderinfo", orderinfo);
             
		//  if(!Util.strIsNull(body))param.put("body", body);
             
		//  if(!Util.strIsNull(instate))param.put("instate", instate);
             
		//  if(!Util.strIsNull(paystate))param.put("paystate", paystate);
             
		//  if(!Util.strIsNull(encashtime))param.put("encashtime", encashtime);
             
		//  if(!Util.strIsNull(eventcode))param.put("eventcode", eventcode);
             
		//  if(!Util.strIsNull(channel))param.put("channel", channel);
             
		//  if(!Util.strIsNull(subchannel))param.put("subchannel", subchannel);
             
		//  if(!Util.strIsNull(agencyno))param.put("agencyno", agencyno);
             
		//  if(!Util.strIsNull(playtype))param.put("playtype", playtype);
             
		//  if(!Util.strIsNull(latedteamid))param.put("latedteamid", latedteamid);
              total=instanceTorderBeanService.findCount(param);
	if(total>0)list=instanceTorderBeanService.find(param, (vo.getPageNum()-1)*vo.getNumPerPage(),
					vo.getNumPerPage());
		
                   vo.setTotalCount(total);	
		model.addAttribute("vo", vo);	
		model.addAttribute("lotno", lotno);	
		model.addAttribute("torderList", list);
		return "/func/torder/list";
	}catch (Exception e) {
		e.printStackTrace();
		return "";
	}
  }
}

