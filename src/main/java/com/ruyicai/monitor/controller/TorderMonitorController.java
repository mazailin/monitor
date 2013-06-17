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
@RequestMapping("/tordermonitor/*")
public class TorderMonitorController extends BaseController {
	@Resource
	public ITorderBeanService instanceTorderBeanService;

	@RequestMapping(value = "/monitorlist", method = RequestMethod.GET)
	public String monitorlist(BaseConditionVO vo,
			@RequestParam(required = false) int type, Model model) {
		if (type == 1)
			return monitorhighfrequency(vo, model);
		if (type == 2)
			return monitorgrail(vo, model);
		if (type == 3)
			return monitorcontest(vo, model);
		return null;
	}

	// 时时彩 T01007
	// 多乐彩T01010
	// 十一运夺金 T01012
	// 广东十一选五T01014
	// 广东快乐十分T01015
	// 2
	// 大盘：
	// 双色球F47104
	// 福彩3D F47103
	// 七乐彩F47102
	// 大乐透T01001
	// 排列三T01002
	// 排列五T01011
	// 七星彩T01009
	// 22选5 T01013
	// 足彩胜负彩T01003
	// 足彩任九场T01004
	// 足彩进球彩T01005
	// 足彩半全场T01006
	// 3
	// 竞彩：
	// J00001 足球让球胜平负
	// J00002 足球比分
	// J00003 足球总进球
	// J00004 半全场
	//
	// J00005 篮球胜负
	// J00006 篮球让分胜负
	// J00007 胜分差
	// J00008 篮球大小分
	//
	// J00009 冠军（自己还没卖）
	// J00010 冠亚军（自己还没卖）
	//
	// J00011 足球混合投注
	// J00012 篮球混合投注
	
	
	//竞彩
	@RequestMapping(value = "/monitorcontest", method = RequestMethod.POST)
	public String monitorcontest(BaseConditionVO vo, Model model) {
		List<MonitorShow> monitorShowList = new ArrayList<MonitorShow>();
		try {
			int kbl = instanceTorderBeanService.findCount(3);
			vo.setTotalCount(kbl);
			if (kbl > 0) {
				List<TorderBeanShow> tbskbl = new ArrayList<TorderBeanShow>();
				Map param = new HashMap();
				param.put("type", 3);
				tbskbl = instanceTorderBeanService.findTorderBeanShow(param,
						(vo.getPageNum() - 1) * vo.getNumPerPage(),
						vo.getNumPerPage());
				for (TorderBeanShow tb : tbskbl) {
					MonitorShow ms = new MonitorShow();
					String res = DateUtils.getTimedifference(
							DateUtils.getNow(), tb.getLastprinttime());
					// if(res.contains("已过期"))continue;

					ms.setKblid(tb.getId());
					ms.setKbllotno(tb.getLotno());
					ms.setKblbatchcode(tb.getBatchcode());
					ms.setKblcreatetime(DateUtils.defaultDateFormat(tb
							.getCreatetime()));
					ms.setKblremainingtime(res);
					monitorShowList.add(ms);
				}
			}
			logger.debug("va total =" + vo.getTotalCount()
					+ " monitorShowList size=" + monitorShowList.size());
		} catch (Exception e) {
			logger.debug("monitor exception ", e);
		}
		model.addAttribute("pageTitle", ServerInitConfigUtil.pageTitle);
		model.addAttribute("loginUserName", "admin");
		model.addAttribute("vo", vo);
		model.addAttribute("monitorShowList", monitorShowList);
		return "/func/torder/monitorcontest";
	}
//大盘
	@RequestMapping(value = "/monitorgrail", method = RequestMethod.POST)
	public String monitorgrail(BaseConditionVO vo, Model model) {
		List<MonitorShow> monitorShowList = new ArrayList<MonitorShow>();
		try {
			int dl = instanceTorderBeanService.findCount(2);
			vo.setTotalCount(dl);
			if (dl > 0) {
				List<TorderBeanShow> tbsdl = new ArrayList<TorderBeanShow>();
				Map param = new HashMap();
				param.put("type", 2);
				tbsdl = instanceTorderBeanService.findTorderBeanShow(param,
						(vo.getPageNum() - 1) * vo.getNumPerPage(),
						vo.getNumPerPage());
				for (TorderBeanShow tb : tbsdl) {
					MonitorShow ms = new MonitorShow();
					String res = DateUtils.getTimedifference(
							DateUtils.getNow(), tb.getLastprinttime());
					// if(res.contains("已过期"))continue;
					ms.setDlid(tb.getId());
					ms.setDllotno(tb.getLotno());
					ms.setDlbatchcode(tb.getBatchcode());
					ms.setDlcreatetime(DateUtils.defaultDateFormat(tb
							.getCreatetime()));
					ms.setDlremainingtime(res);

					monitorShowList.add(ms);
				}
			}
			logger.debug("va total =" + vo.getTotalCount()
					+ " monitorShowList size=" + monitorShowList.size());
		} catch (Exception e) {
			logger.debug("monitor exception ", e);
		}
		model.addAttribute("pageTitle", ServerInitConfigUtil.pageTitle);
		model.addAttribute("loginUserName", "admin");
		model.addAttribute("vo", vo);
		model.addAttribute("monitorShowList", monitorShowList);
		return "/func/torder/monitorgrail";
	}
//高频
	@RequestMapping(value = "/monitorhighfrequency", method = RequestMethod.POST)
	public String monitorhighfrequency(BaseConditionVO vo, Model model) {

		List<MonitorShow> monitorShowList = new ArrayList<MonitorShow>();
		try {
			int hflc = instanceTorderBeanService.findCount(1);
			vo.setTotalCount(hflc);
			if (hflc > 0) {
				List<TorderBeanShow> tbshfl = new ArrayList<TorderBeanShow>();
				Map param = new HashMap();
				param.put("type", 1);
				tbshfl = instanceTorderBeanService.findTorderBeanShow(param,
						(vo.getPageNum() - 1) * vo.getNumPerPage(),
						vo.getNumPerPage());
				for (TorderBeanShow tb : tbshfl) {
					MonitorShow ms = new MonitorShow();
					String res = DateUtils.getTimedifference(
							DateUtils.getNow(), tb.getLastprinttime());
					// if(res.contains("已过期"))continue;

					ms.setHflid(tb.getId());
					ms.setHfllotno(tb.getLotno());
					ms.setHflbatchcode(tb.getBatchcode());
					ms.setHflcreatetime(DateUtils.defaultDateFormat(tb
							.getCreatetime()));

					ms.setHflremainingtime(res);

					monitorShowList.add(ms);
				}
			}
			logger.debug("va total =" + vo.getTotalCount()
					+ " monitorShowList size=" + monitorShowList.size());
		} catch (Exception e) {
			logger.debug("monitor exception ", e);
		}
		model.addAttribute("pageTitle", ServerInitConfigUtil.pageTitle);
		model.addAttribute("loginUserName", "admin");
		model.addAttribute("vo", vo);
		model.addAttribute("monitorShowList", monitorShowList);
		return "/func/torder/monitorhighfrequency";
	}

}
