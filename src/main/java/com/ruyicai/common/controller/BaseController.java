package com.ruyicai.common.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.ruyicai.common.utils.ServerInitConfigUtil;
import com.ruyicai.common.utils.Utils;
import com.ruyicai.common.utils.date.DateUtils;
import com.ruyicai.common.vo.AjaxDone;
/**{statusCode=DWZ.statusCode.timeout表示session超时，下次点击时跳转到DWZ.loginUrl
* {"statusCode":"200", "message":"操作成功", "navTabId":"navNewsLi", "forwardUrl":"", "callbackType":"closeCurrent", "rel"."xxxId"}
* {"statusCode":"300", "message":"操作失败"}
* {"statusCode":"301", "message":"会话超时"}
*/ 

public class BaseController {
	protected Logger logger = Logger.getLogger(getClass());
	protected Boolean success = true;
	protected Integer total = 0;
	protected ModelMap model = new ModelMap();
	protected String returnMessage=null;
	protected int start = 0; // start
	protected int limit = 20; // pagesize
	@Resource
	private ServerInitConfigUtil serverInitConfigUtil;
	
	protected ModelAndView ajaxDone(int statusCode, String message,AjaxDone param) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		if(param!=null){
			if(!Utils.strIsNull(param.getNavTabId()))mav.addObject("navTabId", param.getNavTabId());
			if(!Utils.strIsNull(param.getForwardUrl()))mav.addObject("forwardUrl", param.getForwardUrl());
			if(!Utils.strIsNull(param.getCallbackType()))mav.addObject("callbackType", param.getCallbackType());
			if(!Utils.strIsNull(param.getRel()))mav.addObject("rel", param.getRel());
		}
		return mav;
	}
 
	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message,null);
	}

	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message,null);
	}
	protected String getMessage(String code) {
		return  serverInitConfigUtil.getMessage("code." +code);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

			@Override
			public String getAsText() {
				if (this.getValue() == null) {
					return "";
				}
				return DateUtils.defaultDateFormat((Date) this.getValue());
			}

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (null == text || text.equals("")) {
					return;
				}
				Date value=DateUtils.changStringToDate(text);
				if(value==null) {
					this.setValue(new Date());
				}else{ 
					this.setValue(value);
				}
			}
		});
	}
	 @ExceptionHandler(Exception.class)
	  public String handleIOException(Exception ex, HttpServletRequest request) {
		  if(logger.isDebugEnabled())
			  logger.debug(this.getClass().getName()+"this class hadnle exception:",ex);
	    return ClassUtils.getShortName(ex.getClass());
	  }
//	public String processException(PerseusException e) {
//		String msg = null;
//		if (e.getFields() != null) {
//			Object[] fields = new Object[e.getFields().length];
//			for (int i = 0; i < fields.length; i++) {
//				fields[i] = ConfigUtil.getMessage(e.getFields()[i]);
//			}
//			msg = ConfigUtil.getMessage("code." + e.getResultCode(), fields);
//
//		} else {
//			msg = ConfigUtil.getMessage("code." + e.getResultCode());
//
//		}
//		return msg;
//	}
	public String processException(String resultCode) {
		String msg = null;
			msg = serverInitConfigUtil.getMessage("code." +resultCode);
		return msg;
	}
	
	
}
