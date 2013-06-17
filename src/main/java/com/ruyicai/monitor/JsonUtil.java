package com.ruyicai.monitor;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

import com.ruyicai.common.exception.CCSRuntimeException;



/**
 * JSON转换工具类
 */
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	

	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new CCSRuntimeException("OrderRequest.toJson error", e);
		}
	}

	public static <T> T fromJsonToObject(String body, Class<T> clazz) {
		try {
			objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return objectMapper.readValue(body, clazz);
		} catch (Exception e) {
			throw new CCSRuntimeException("OrderRequest.fromJsonToOrderRequest error", e);
		}
	}
}
