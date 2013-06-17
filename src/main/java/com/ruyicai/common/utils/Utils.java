package com.ruyicai.common.utils;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.exception.CCSRuntimeException;

public class Utils {
	private static final Log log = LogFactory.getLog(Utils.class);

	public static void setParameter(Map map, String tagName, String mapKey,
			Object faultValue, HttpServletRequest request) {
		String object = request.getParameter(tagName);
		if ((object == null) || (object.equals(faultValue))) {
			return;
		}

		map.put(mapKey, object);
	}

	/**
	 * 逗号风格字符串 ,返回结果去重
	 * @param str
	 * @return
	 */
	public static String[] splitByCommaWithoutDuplicate(String str) {
		String[] s = splitByComma(str);
		List list = new ArrayList();
		for (int i = 0; i < s.length; i++) {
			if (list.contains(s[i])) {
				continue;
			}
			list.add(s[i]);
		}
		String[] ret = new String[list.size()];
		list.toArray(ret);
		return ret;
	}
    /**
     * 复制字符串数组
     * @param str
     * @return
     */
	public static String[] duplicate(String[] str) {
		Set set = new HashSet(Arrays.asList(str));
		return (String[]) set.toArray(new String[0]);
	}
    /**
     * 逗号风格字符串   
     * @param str
     * @return
     */
	public static String[] splitByComma(String str) {
		return splitBy(str, ',');
	}

   /**
    * 制定分隔符分割字符串
    * @param str
    * @param sp
    * @return
    */
	public static String[] splitBy(String str, char sp) {
		if (str == null) {
			return new String[0];
		}
		str = str.trim();
		if (str.equals("")) {
			return new String[0];
		}
		List list = new ArrayList();
		StringBuffer sb = new StringBuffer();
		boolean inQuote = false;

		int len = str.length();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (ch == '\\' && (i + 1) < len) { // \?
				++i;
				ch = str.charAt(i);
				sb.append(ch);
				continue;
			} else if ((sb.length() == 0)
					&& (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')) {
				continue;
			} else if (i + 1 == len) {
				if (ch == '"' && inQuote) {
					inQuote = false;
					String s = sb.toString().trim();
					sb.delete(0, sb.length());
					list.add(s);
				} else if (ch != sp) {
					sb.append(ch);
					String s = sb.toString().trim();
					sb.delete(0, sb.length());
					list.add(s);
				} else {
					String s = sb.toString().trim();
					sb.delete(0, sb.length());
					list.add(s);
					list.add("");
				}
				break;
			} else if (ch == sp && !inQuote) {
				String s = sb.toString().trim();
				sb.delete(0, sb.length());
				list.add(s);
				continue;
			}

			if (ch == '\"' && sb.length() == 0 && str.indexOf('\"', i + 1) > 0) { // "
				inQuote = true;
			} else if (ch == '\"' && inQuote) { // "
				inQuote = false;
			} else {
				sb.append(ch);
			}
		}

		String[] ret = new String[list.size()];
		list.toArray(ret);
		return ret;
	}
    
	/**
	 * map为空或所有的key为空
	 * @param map
	 * @return
	 */
	public static boolean mapIsNull(Map map) {
		if (map != null && !map.isEmpty()) {
			Object[] keys = map.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				if (!mapIsNull(map, keys[i])) {
					return false;
				}
			}
			return true;
		} else {
			return true;
		}
	}
/**
 * map为空或指定的key为空
 * @param map
 * @param key
 * @return
 */
	public static boolean mapIsNull(Map map, Object key) {
		if (map != null && !map.isEmpty() && map.get(key) != null) {
			return false;
		} else {
			return true;
		}
	}

	public static void setParameter(Map map, String tagName, Object faultValue,
			HttpServletRequest request) {
		setParameter(map, tagName, tagName, faultValue, request);
	}

	public static boolean strIsNull(String str) {
		return ((str == null) || "".equals(str));
	}

	public static boolean objIsNull(Object str) {
		return ((str == null));
	}

	public static boolean integerIsNull(Integer i) {
		return ((i == null) || "".equals(i));
	}

	public static boolean longIsNull(Long i) {
		return ((i == null) || "".equals(i));
	}

	/**
	 * check if List list is null
	 * 
	 * @param list
	 *            List
	 * @return boolean
	 */
	public static boolean listIsNull(List list) {
		if (list != null && !list.isEmpty() && list.get(0) != null) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean arrayIsNull(Object[] aObj) {
		if (aObj != null && aObj.length > 0) {
			for (int i = 0; i < aObj.length; i++) {
				if (aObj[i] != null && !"".equals(aObj[i])) {
					return false;
				}
			}
		}
		return true;
	}

	public static String getTrimParameter(HttpServletRequest request,
			String name) {
		String value = request.getParameter(name);
		if (value == null) {
			return "";
		} else {
			return value.trim();
		}
	}

	public static String getStringParameter(HttpServletRequest request,
			String name, boolean required, int maxLength, String fieldLabel) {
		String value = getTrimParameter(request, name);
		if (required && value.length() == 0) {
			throw new CCSRuntimeException(Contants.CODE_REQUIRED,
					fieldLabel);
		}
		if (maxLength != -1) {
			validateMaxLength(fieldLabel, value, required, maxLength);
		}
		return value;
	}

	public static boolean getBooleanParameter(HttpServletRequest request,
			String name) {
		String value = getTrimParameter(request, name);
		return Boolean.valueOf(value).booleanValue();
	}

	public static int getIntParameter(HttpServletRequest request, String name,
			boolean required, String fieldLabel, int defaultValue) {
		try {
			return getIntParameter(request, name, required, fieldLabel);
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static int getIntParameter(HttpServletRequest request, String name,
			boolean required, String fieldLabel) {
		String value = getTrimParameter(request, name);
		if (required && value.length() == 0) {
			throw new CCSRuntimeException(Contants.CODE_REQUIRED,
					fieldLabel);
		}
		validateNumber(fieldLabel, value, required, Contants.DATA_INTEGER);
		return Integer.parseInt(value, 10);
	}

	public static int[] getIntParameters(HttpServletRequest request,
			String name, boolean required, String fieldLabel) {
		String[] value = request.getParameterValues(name);
		if (required && (value == null || value.length == 0)) {
			throw new CCSRuntimeException(Contants.CODE_REQUIRED,
					fieldLabel);
		}
		int values[] = new int[value.length];
		for (int i = 0; i < value.length; i++) {
			validateNumber(fieldLabel, value[i], required,
					Contants.DATA_INTEGER);
			values[i] = Integer.parseInt(value[i], 10);
		}
		return values;
	}

	public static void populate(HttpServletRequest request, Object dest,
			String paramName, String propertyName, boolean ignoreEmptyString) {
		String value = request.getParameter(paramName);
		if (dest == null
				|| (ignoreEmptyString && (value == null || value.trim()
						.length() == 0))) {
			log.debug("No property to populate");
			return;
		}
		setProperty(dest, propertyName, value);
	}

	public static void populate(HttpServletRequest request, Object dest,
			boolean ignoreEmptyString) {
		Enumeration en = request.getParameterNames();
		if (en == null || dest == null) {
			log.debug("No property to populate");
			return;
		}
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String value = request.getParameter(name);
			if (ignoreEmptyString && (value == null || value.trim().equals(""))) {
				if (log.isDebugEnabled()) {
					log.debug("Property " + name + " is empty, ignore it");
				}
				continue;
			} else {
				value = toTrimmedString(value);
				setProperty(dest, name, value);
			}
		}
	}
    /**
     * 反 射设置对象的属性
     * @param dest
     * @param propertyName
     * @param value
     */
	public static void setProperty(Object dest, String propertyName,
			String value) {
		if (log.isDebugEnabled()) {
			log.debug("Setting property " + propertyName + " = " + value);
		}

		if (dest instanceof Map) {
			((Map) dest).put(propertyName, value);
			log.debug("Property was set");
			return;
		}

		String setterMethodName = "set"
				+ propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);

		try {
			Method m = dest.getClass().getMethod(setterMethodName,
					new Class[] { String.class });
			if (m != null) {
				try {
					m.invoke(dest, new Object[] { value });
					log.debug("Property was set");
					return;
				} catch (IllegalArgumentException ex) {
					log.debug("IllegalArgumentException", ex);
				} catch (IllegalAccessException ex) {
					log.debug("IllegalAccessException", ex);
				} catch (InvocationTargetException ex) {
					log.debug("InvocationTargetException", ex);
				}
			}
		} catch (SecurityException ex) {
			// log.debug("SecurityException", ex);
		} catch (NoSuchMethodException ex) {
			// log.debug("NoSuchMethodException", ex);
		}

		Method[] methods = dest.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equalsIgnoreCase(setterMethodName)) {
				Class[] types = methods[i].getParameterTypes();

				if (types.length == 1) {
					Object param = value;
					if (types[0].equals(String.class)) {
						;
					} else if (types[0] == Boolean.class
							|| types[0] == boolean.class) {
						param = Boolean.valueOf(value);
					} else if (types[0] == Float.class
							|| types[0] == float.class) {
						param = Float.valueOf(value);
					} else if (types[0] == Double.class
							|| types[0] == double.class) {
						param = Double.valueOf(value);
					} else if (types[0] == Integer.class
							|| types[0] == int.class) {
						param = Integer.valueOf(value);
					} else if (types[0] == Long.class || types[0] == long.class) {
						param = Long.valueOf(value);
					} else if (types[0] == (Date.class)) {
						if (validateLong(value)) {
							long millis = Long.parseLong(value);
							if (millis < 114812113977L) {
								millis = millis * 1000;
							}
							param = new Date(millis);
						} else {
							try {
								param = getDefaultDateFormat().parse(value);
							} catch (ParseException ex) {
								log.debug("Parse date format error: " + value);
							}
						}
					} else {
						log.debug("Unsupport property type: "
								+ types[0].getName());
						continue;
					}
					try {
						methods[i].invoke(dest, new Object[] { param });
						log.debug("Property was set");
						break;
					} catch (IllegalArgumentException ex) {
						log.debug("IllegalArgumentException", ex);
					} catch (IllegalAccessException ex) {
						log.debug("IllegalAccessException", ex);
					} catch (InvocationTargetException ex) {
						log.debug("InvocationTargetException", ex);
					}
				}
			}
		}
	}

	
	/**
	 * Checks if the field can safely be converted to an int primitive.
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean validateInt(String value) {

		if (strIsNull(value)) {
			return false;
		}

		try {
			new Integer(value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if the field can safely be converted to an double primitive.
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean validateDouble(String value) {

		if (strIsNull(value)) {
			return false;
		}

		try {
			new Double(value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if the field can safely be converted to an long primitive.
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean validateLong(String value) {

		if (strIsNull(value)) {
			return false;
		}

		try {
			new Long(value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if the field can safely be converted to an float primitive.
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean validateFloat(String value) {

		if (strIsNull(value)) {
			return false;
		}

		try {
			new Float(value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	

	/**
	 * <p>
	 * Checks if the value's length is less than or equal to the max.
	 * </p>
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean validateMaxlength(String value, int maxLength) {
		int len = getByteAccount(value, Contants.DATABASE_CHARSET);
		return ((len != -1) && (len <= maxLength));
	}

	public static SimpleDateFormat getDefaultDateFormat() {
		SimpleDateFormat df = new SimpleDateFormat(Contants.PATTERN_TIMESTAMP);
		df.setTimeZone(TimeZone.getTimeZone(Contants.DEFAULT_TIMEZONE));
		return df;
	}

	public static int getByteAccount(String str, String charsetName) {
		if (str == null) {
			return 0;
		}
		byte[] bs = null;
		try {
			bs = str.getBytes(charsetName);
		} catch (UnsupportedEncodingException ex) {
			log.warn(str, ex);
			return -1;
		}
		if (bs == null) {
			return -1;
		}
		return bs.length;
	}


	
	public static String getString(Object obj) {
		if (obj == null || obj.equals("")) {
			return "";
		} else {
			return obj.toString();
		}

	}

	public static Object getObjectFormArr(Object[] arr, int pos) {
		Object value = null;
		try {
			value = arr[pos];
		} catch (Exception e) {
			;
		}
		return value;
	}

	public static String toTrimmedString(Object value) {
		if (value == null) {
			return null;
		}
		return value.toString().trim();
	}

	public static String longDecimalFormat(String pattern, long longValue) {
		String strOfNumber = null;
		try {
			DecimalFormat format = new DecimalFormat(pattern);
			strOfNumber = format.format(longValue);
		} catch (Exception e) {
			strOfNumber = String.valueOf(longValue);
		}
		return strOfNumber;
	}

	public static String doubleDecimalFormat(String pattern, double longValue) {
		String strOfNumber = null;
		try {
			DecimalFormat format = new DecimalFormat(pattern);
			strOfNumber = format.format(longValue);
		} catch (Exception e) {
			strOfNumber = String.valueOf(longValue);
		}
		return strOfNumber;
	}

	public static String floatDecimalFormat(String pattern, float longValue) {
		String strOfNumber = null;
		try {
			DecimalFormat format = new DecimalFormat(pattern);
			strOfNumber = format.format(longValue);
		} catch (Exception e) {
			strOfNumber = String.valueOf(longValue);
		}
		return strOfNumber;
	}

	public static String formatDate(Date myDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public static Long convertDateTextToTimestamp(String t) {
		SimpleDateFormat f = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		try {
			Date d = f.parse(t);
			return d.getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
			return Long.MIN_VALUE;
		}
	}

	
	public static String convertDateTextToTimestamp(Date d, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(d);
	}

	public static String convertDateTextToTimestamp(String d, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(d);
	}

	/**
	 * @param pattern
	 *            :yy-MM-dd HH:mm:ss
	 * @param d
	 *            :2012-03-04 00:00:00
	 * @return :秒数
	 * @throws ParseException
	 */
	public static Long toseconds(String pattern, String d)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern(pattern);
		Date date = df.parse(d);
		Long time = convertDateTextToTimestamp(date.toString());
		return time;
	}

	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 */
	public static void validateRequired(String field, String value) {
		if (Utils.strIsNull(value)) {
			throw new CCSRuntimeException(Contants.CODE_REQUIRED,
					new String[] { field });
		}

	}

	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 * @param required
	 *            boolean
	 * @param dataType
	 *            int
	 */
	public static void validateNumber(String field, String value,
			boolean required, int dataType) {
		if (Utils.strIsNull(value)) {
			if (required) {
				throw new CCSRuntimeException(Contants.CODE_REQUIRED,
						new String[] { field });
			} else {
				return;
			}
		}
		validateNumber(field, value, dataType);
	}

	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 * @param required
	 *            boolean
	 * @param maxLength
	 *            int
	 */
	public static void validateMaxLength(String field, String value,
			boolean required, int maxLength) {
		if (Utils.strIsNull(value)) {
			if (required) {
				throw new CCSRuntimeException(Contants.CODE_REQUIRED,
						new String[] { field });
			} else {
				return;
			}
		}

		if (maxLength > 0 && !Utils.validateMaxlength(value, maxLength)) {
			throw new CCSRuntimeException(Contants.CODE_MAXLENGTH,
					new String[] { field, String.valueOf(maxLength) });
		}

	}

	
	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 * @param dataType
	 *            int
	 */
	public static void validateNumber(String field, String value, int dataType) {
		if (dataType == Contants.DATA_INTEGER) {
			if (!Utils.validateInt(value)) {
				throw new CCSRuntimeException(Contants.CODE_INTEGER,
						new String[] { field });

			}
		} else if (dataType == Contants.DATA_LONG) {
			if (!Utils.validateLong(value)) {
				throw new CCSRuntimeException(Contants.CODE_LONG,
						new String[] { field });

			}
		} else if (dataType == Contants.DATA_DOUBLE) {
			if (!Utils.validateDouble(value)) {
				throw new CCSRuntimeException(Contants.CODE_DOUBLE,
						new String[] { field });

			}
		}

	}

	

	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 * @param required
	 *            boolean
	 * @param maxLength
	 *            int
	 */
	public static void validateIpAddress(String field, String value,
			boolean required) {
		if (Utils.strIsNull(value)) {
			if (required) {
				throw new CCSRuntimeException(Contants.CODE_REQUIRED,
						new String[] { field });
			} else {
				return;
			}
		}
		validateIpAddress(field, value);

	}

	/**
	 * 
	 * @param field
	 *            String
	 * @param value
	 *            String
	 */
	public static void validateIpAddress(String field, String value) {
		boolean ipPartStatus = false;
		String[] ipPart = null;
		ipPart = value.split("\\.");
		if (ipPart.length != 4) {
			throw new CCSRuntimeException(Contants.CODE_IPADDRESS_INVALID,
					new String[] { field });
		}
		for (int i = 0; i < ipPart.length; i++) {
			int ipPar = Integer.parseInt(ipPart[i]);
			if (ipPar >= 0 && ipPar <= 255) {
				ipPartStatus = false;
				continue;
			} else {
				ipPartStatus = true;
				break;
			}
		}
		if (ipPartStatus) {
			throw new CCSRuntimeException(Contants.CODE_IPADDRESS_INVALID,
					new String[] { field });
		}

	}

	public static String processStringDefault(Object Str) {
		if (Str == null || Str.equals("")) {
			return "";
		} else {
			return Str.toString();
		}
	}

	public static String leftTrims(String Str) {
		if (Str == null || Str.equals("")) {
			return Str;
		} else {
			String RegularExp = "^[　 ]+";
			return Str.replaceAll(RegularExp, "");
		}
	}

	public static String rightTrims(String Str) {
		if (Str == null || Str.equals("")) {
			return Str;
		} else {
			Str = "" + Str;
			String RegularExp = "[　 ]+$";
			return Str.replaceAll(RegularExp, "");
		}
	}

	public static String trims(String Str) {
		if (Str == null || Str.equals("")) {
			return Str;
		} else {
			Str = "" + Str;
			String RegularExp = "^[　 ]+|[　 ]+$";
			return Str.replaceAll(RegularExp, "");
		}
	}

}
