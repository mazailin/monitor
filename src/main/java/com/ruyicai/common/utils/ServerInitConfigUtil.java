package com.ruyicai.common.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.utils.props.CCSProps;
import com.ruyicai.common.utils.props.Props;

/**
 *this class is server initial action 
 *parse the page and server configuration  
 * 
 * @author T
 * 
 */
@Component
public class ServerInitConfigUtil {
	private static Logger logger = Logger.getLogger(ServerInitConfigUtil.class);
	public static String pagename;
	public static String pageTitle;
	public static String ctiserverIP;
//	public static String loginmessage;
//	public static String layoutmessage;
	public static String copyright;
	public static String accordiontrees;
	public static String BASE_URL;
	static String headmenue;
	public static boolean validateCode;
	public static boolean validatefoot;
	@Resource(name = "messageSource")
	private  MessageSource messageSource;

	
	@PostConstruct
	public void initIt() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Init method after properties are set : ");
		
		CCSProps servProps = Props.instance().getServProps();
		pageTitle=servProps.get(Contants.PAGE_TITLE);
		copyright=servProps.get(Contants.COPY_RIGHT);
		pagename=servProps.get(Contants.PAGE_NAME);
		validateCode=servProps.getBoolean(Contants.LOGINPAGE_VALIDCODE, false);
		validatefoot=servProps.getBoolean(Contants.PAGE_FOOTERPAGE_VALID, false);
		ctiserverIP=servProps.get("ctiserverIP","192.168.0.88");
		headmenue=null;
		accordiontrees=null;
	}
	public  String getMessage(String key, Object[] args) {
		try {
			return messageSource.getMessage(key, args,
					Contants.DEFAULT_LOCALE);
		} catch (NoSuchMessageException e) {
			logger.warn("Message of key " + key + " NOT found!");
			return key;
		}
	}

	public  String getMessage(String key) {
		try {
			return messageSource.getMessage(key, null,
					Contants.DEFAULT_LOCALE);
		} catch (NoSuchMessageException e) {
			logger.warn("Message of key " + key + " NOT found!");
			return key;
		}
	}


	@PreDestroy
	public void cleanUp() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Spring Container is destroy! Customer clean up");
		pageTitle = null;
		pagename = null;
		copyright = null;
//		style = null;
//		loginmessage = null;
//		layoutmessage = null;
	}

	
}
