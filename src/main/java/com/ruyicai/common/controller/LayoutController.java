package com.ruyicai.common.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.ServerInitConfigUtil;
import com.ruyicai.common.utils.date.DateUtils;
import com.ruyicai.common.utils.http.HttpUtil;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.common.vo.BaseConditionVO;
import com.ruyicai.monitor.domainshow.MonitorShow;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;
import com.ruyicai.monitor.service.ITorderBeanService;
import com.ruyicai.systemmanage.service.IClient;
import com.ruyicai.systemmanage.vo.ResourceVo;


@Controller
@RequestMapping("/layout")
public class LayoutController {
	@Resource
	private IClient generateResource;
//	 @Resource
//		public ITorderBeanService instanceTorderBeanService;
		
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String defaultProcess(HttpServletRequest request,
ModelMap model,BaseConditionVO vo)  {
		try {
			parseBaseUrl(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		String username= "admin";//LoggerUtil.getLoginUserName();
		String pageTitle = ServerInitConfigUtil.pageTitle;
		String copyright = ServerInitConfigUtil.copyright;
		int validatefoot=ServerInitConfigUtil.validatefoot?1:0;
		
		 List<ResourceVo> resources=new ArrayList<ResourceVo>();
		 List<ResourceVo> children=new ArrayList<ResourceVo>();
		 ResourceVo child=new ResourceVo();
		 child.setDescription("业务管理");
		 child.setExpanded(true);
		 child.setId("001001");
		 child.setLeaf(true);
		 child.setPath("/torder/list");
		 child.setTarget("navTab");
		 child.setText("业务管理");
		 child.setRel("torderLiNav");
		 children.add(child);
		 ResourceVo child2=new ResourceVo();
		 child2.setDescription("出票监测");
		 child2.setExpanded(true);
		 child2.setId("001002");
		 child2.setLeaf(true);
		 child2.setPath("/torder/monitorlist");
		 child2.setTarget("navTab");
		 child2.setText("出票监测");
		 child2.setRel("monitorLiNav");
		 children.add(child2);
		 ResourceVo child3=new ResourceVo();
		 child3.setDescription("高频彩监测");
		 child3.setExpanded(true);
		 child3.setId("001003");
		 child3.setLeaf(true);
		 child3.setPath("/tordermonitor/monitorlist?type=1");
		 child3.setTarget("navTab");
		 child3.setText("高频彩监测");
		 child3.setRel("highfrequencyLiNav");
		 children.add(child3);
		 ResourceVo child4=new ResourceVo();
		 child4.setDescription("大盘彩监测");
		 child4.setExpanded(true);
		 child4.setId("001004");
		 child4.setLeaf(true);
		 child4.setPath("/tordermonitor/monitorlist?type=2");
		 child4.setTarget("navTab");
		 child4.setText("大盘彩监测");
		 child4.setRel("grailLiNav");
		 children.add(child4);
		 ResourceVo child5=new ResourceVo();
		 child5.setDescription("竞彩监测");
		 child5.setExpanded(true);
		 child5.setId("001005");
		 child5.setLeaf(true);
		 child5.setPath("/tordermonitor/monitorlist?type=3");
		 child5.setTarget("navTab");
		 child5.setText("竞彩监测");
		 child5.setRel("contestLiNav");
		 children.add(child5);
		 ResourceVo root=new ResourceVo();
		 root.setChildren(children);
		 root.setDescription("系统管理");
		 root.setExpanded(true);
		 root.setId("001");
		 root.setLeaf(false);
		 root.setPath("/user");
		 root.setTarget("navTab");
		 root.setText("系统管理");
		 root.setRel("userLiNav");
		 resources.add(root);
//		 List<MonitorShow> monitorShowList=new ArrayList<MonitorShow>();
//		 MonitorShow ms=new MonitorShow();
//		 ms.setHflid("BJ2013031311972345");
//		 ms.setHflcreatetime("2013-03-12 12:12");
//		 ms.setHflremainingtime("<span>5</span>小时&nbsp;<span>20</span>分钟&nbsp;<span>30</span>秒");
//		 ms.setDlid("BJ2013031311972345");
//		 ms.setDlcreatetime("2013-03-12 12:12");
//		 ms.setDlremainingtime("<span>5</span>小时&nbsp;<span>20</span>分钟&nbsp;<span>30</span>秒");
//		 ms.setKblid("BJ2013031311972345");
//		 ms.setKblcreatetime("2013-03-12 12:12");
//		 ms.setKblremainingtime("<span>5</span>小时&nbsp;<span>20</span>分钟&nbsp;<span>30</span>秒");
//		 monitorShowList.add(ms);
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone()); monitorShowList.add(ms.clone());
//		 
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone()); monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 
//		 monitorShowList.add(ms.clone()); monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());
//		 monitorShowList.add(ms.clone());  
//		   vo.setTotalCount(monitorShowList.size());	
			model.addAttribute("vo", vo);
		 
		 String   accordiontrees =generateResource.createTreeString(resources,false);
		String headmenu=null;//roleService.getTreeResource("系统管理员",true);//
		model.addAttribute("pageTitle",pageTitle);
		model.addAttribute("treeMenus",accordiontrees);//ServerInitConfigUtil.tree);
		model.addAttribute("navMenus",headmenu); 
		model.addAttribute("loginUserName",username);
		model.addAttribute("copyright",copyright);
		model.addAttribute("validatefoot",validatefoot);
//		model.addAttribute("monitorShowList", monitorShowList);
		return ServerInitConfigUtil.pagename;
		
	}
	/**
	 * 解析URL，得到后部分的URI
	 * 
	 * @return
	 * @throws Exception
	 */
	private String parseURL(HttpServletRequest request) throws Exception {
		String uri = URLDecoder.decode(request.getRequestURI(), "utf-8");
		String contextPath = URLDecoder.decode(request.getContextPath(),"utf-8");

		if (contextPath != null && contextPath.trim().length() > 0)
			return uri.replace(contextPath + "/", "");

		return uri.substring(1);
	}

	private void parseBaseUrl(HttpServletRequest request ) throws Exception {

		ServletContext servletContext = request.getSession().getServletContext();
		
		String uri = parseURL(request);

		if (servletContext.getAttribute(Contants.BASE_URL_KEY) == null) {
			String url = URLDecoder.decode(request.getRequestURL().toString(),"utf-8");

			String baseUrl = url.replace(uri, "");
			ServerInitConfigUtil.BASE_URL = baseUrl;
			servletContext.setAttribute(Contants.BASE_URL_KEY, baseUrl);
		}

	}
}
