package com.ruyicai.monitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

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
public class ServerInitCache {
	private static Logger logger = Logger.getLogger(ServerInitCache.class);
	public  static List<String> customerresponse;
	public  static Map<String,String> customerresponseservice=new HashMap<String,String>();
	@PostConstruct
	public void initIt() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Init method after properties are set : ");
		CCSProps sp=Props.instance().getServProps();
		customerresponse=	sp.getList("customerresponse");
		for( String code:customerresponse )
			customerresponseservice.put(code, sp.get(code+".service"));
			
	}



	@PreDestroy
	public void cleanUp() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Spring Container is destroy! Customer clean up");
	}

	
}
