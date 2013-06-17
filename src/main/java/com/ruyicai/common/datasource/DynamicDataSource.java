package com.ruyicai.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {
	
	protected Object determineCurrentLookupKey() {
		String className=RuyicaiContextHolder.getContextHolderData();
		return className;
	}
}
