package com.ruyicai.common.constants;

import java.util.Locale;

public class Contants {
	// field related
	public static final String FIELD_STARTDATE = "startdate";
	public static final String FIELD_ENDDATE = "enddate";

	// pdf html word file related
	public static final String TRUE_BOOL_STRING = "Y";
	public static final String FALSE_BOOL_STRING = "N";
	public static final String SPLIT_FLAG_STRING = ",";
	public static final String LINE_FLAG_STRING = "\n";
	public static final String EMPTY_VALUE_STRING = "";
	public static final String START_CAHCECLASS_STRING = "CACHE";
	public static final Object EMPTY_OBJECT = new Object();
	public static final int MAX_ERROR_LOGIN_COUNT = 3;
	public static final int ERROR_LOGIN_DURATION = 10;
	public static final int LOCK_DURATION = 5;
	public static String PDF_DATA_SPLIT = ";";
	// database related
	public static final int PAGING_FIRST = 1;
	public static final int PAGING_PREVIOUS = 2;
	public static final int PAGING_NEXT = 3;
	public static final int PAGING_LAST = 4;
	public static final int PAGING_OLD = 5;
	public static final int PAGING_YES = 1;
	public static final int PAGING_NO = 0;
	public static int PAGE_SIZE = 20;
	public static int PAGING_RECORD_LIMIT = 20;
	// date related
	public static final String PROCESS_ID_PATTERN = "yyyyMMddHHmmssSS";
	public static final String CHS_SHORT_DATE_FORMAT_MASK = "MM-dd";
	public static final String CHS_DATE_FORMAT_MASK = "yyyy-MM-dd";
	public static final String CHS_DATETIME_FORMAT_MASK = "yyyy-MM-dd HH:mm:ss";
	public static final String HK_SHORT_DATE_FORMAT_MASK = "dd/MM";
	public static final String HK_DATE_FORMAT_MASK = "dd/MM/yyyy";
	public static final String HK_DATETIME_FORMAT_MASK = "dd/MM/yyyy HH:mm:ss";
	public static final String TIME_FORMAT_MASK = "HH:mm:ss";
	public static final String TIME_FORMAT_SHORT_MASK = "HH:mm";
	public static final int SECONDS_PER_DAY = 86400;
	public static final int MILLISECONDS_PER_DAY = 86400000;
	public static final long SECONDS_PER_YEAR = 31536000L;
	public static final long MILLISECONDS_PER_YEAR = 31536000000L;
	public static final String JAN = "JAN";
	public static final String FEB = "FEB";
	public static final String MAR = "MAR";
	public static final String APR = "APR";
	public static final String MAY = "MAY";
	public static final String JUN = "JUN";
	public static final String JUL = "JUL";
	public static final String AUG = "AUG";
	public static final String SEP = "SEP";
	public static final String OCT = "OCT";
	public static final String NOV = "NOV";
	public static final String DEC = "DEC";
	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	public static final String SUNDAY = "Sunday";
	public static final String MON = "MON";
	public static final String TUE = "TUE";
	public static final String WED = "WED";
	public static final String THU = "THU";
	public static final String FRI = "FRI";
	public static final String SAT = "SAT";
	public static final String SUN = "SUN";
	public static final String STRING_UNIT_SECOND = "Second";
	public static final String STRING_UNIT_MINUTE = "Minute";
	public static final String STRING_UNIT_HOUR = "Hour";
	public static final String STRING_UNIT_DAY = "Day";
	public static final String STRING_UNIT_MONTH = "Month";
	public static final String STRING_INVALID_YEAR = "1896";

	public static final String RESOURCE_PARENT_DEFAULTVALUE = "0";
	// project model
	public static final String MODEL_ID_DEFAULT = "defaultDS";
	public static final String MODEL_ID_AGC = "agcDS";
	
	public static enum RedisMessageType {
		server_status, skey_query
	}

	public static final int USER_LOCKED = 1;
	public static final int USER_UNLOCKED = 0;
	public static final long CONFIG_FILE_PERIOD = 5 * 60 * 1000;
	public static final String CONFIG_TREE_XML = "config.xml";
	// date releated
	public static final String DATE_FORMAT_ZH = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public final static String DATE_FORMAT_DAY = "yyyy-MM-dd";
	public static final String DRAGGABLE_ATTR = "draggable";
	public static final String ICONCLS_ATTR = "iconCls";
	public final static String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
	public static final String ID_ATTR = "id";
	public static final String LEAF_ATTR = "leaf";
	public static final String ORDER_ATTR = "order";
	
	public static final String MODULEID_ATTR = "moduleId";
	public static final String PAGETITLE_TAG = "pageTitle";
	public static final String PAGETITLELEFT_TAG = "pageTitleLeft";
	public static final String PAGETITLERIGHT_TAG = "pageTitleRight";
	public static final String PARAMS_ATTR = "params";
	public static final String STYLE_TAG = "style";

	public static final String TEXT_ATTR = "text";

	public static final String TREE_TAG = "trees";

	public static final String VALID_ATTR = "valid";
	public static final String HEAD_ATTR = "head";
	// for HTTP XML Parse
	public static final String XML_ATTR_RESULT = "result";
	public static final String XML_ATTR_CODE = "code";
	public static final String XML_ATTR_MSG = "msg";
	public static final String XML_ATTR_FILE = "file";
	public static final String XML_ATTR_NAME = "name";
	public static final String XML_ATTR_MD5 = "MD5";
	public static final String XML_ATTR_STATUS1 = "status1";
	public static final String XML_ATTR_STATUS2 = "status2";
	public static final String XML_ATTR_STATUS3 = "status3";
	public static final String XML_ATTR_ENGINE = "engine";
	public static final String XML_ATTR_STATUS = "status";
	public static final String XML_RESULT_RESULTCODE = "resultCode";
	public static final String XML_RESULT_RESULTMSG = "resultMsg";
	public static final String XML_RESULT_RESULTFILES = "resultFiles";

	public final static String SESSION_ID = "sessionId";

	public final static String DEFAULT_TIMEZONE = "GMT+8";

	public final static Locale DEFAULT_LOCALE = Locale.CHINA;

	public final static String DEFAULT_ENCODINIG = "UTF-8";

	public final static String DATABASE_CHARSET = "UTF-8";

	public final static int DEFAULT_SESSION_TIMEOUT = 600; // second

	public final static String ROOT_AREA_ID = "<ROOT>";

	public final static String ALL_PERMISSION = ".*";

	public final static long REPEAT_INTERVAL = 10L * 60L * 1000L;// 10minutes

	public final static String ROLE_NAME_SYSADMIN = "sysadmin";
	
	//data validate
	public final static int DATA_INTEGER = 1;

	public final static int DATA_LONG = 2;

	public final static int DATA_DOUBLE = 3;
	// result code
	public static final String CODE_SUCCESS = "0";

	public static final String CODE_DEPLOY_ERROR = "1";

	public static final String CODE_DATABASE_ACCESS_ERROR = "2";

	public static final String CODE_UNSUPPORTED_COMMAND_ERROR = "3";

	public static final String CODE_XML_INVALID = "4";
	
	public static final String CODE_SERVER_EERORS = "5";
	
	public static final String CODE_MAXLENGTH = "6";
	
	public static final String CODE_CANNOT_GET_JDBC_CONNECTION = "7";

	public static final String CODE_REQUIRED = "8";
	
	public static final String CODE_BYTE = "9";

	public static final String CODE_DATE = "10";

	public static final String CODE_DOUBLE = "11";

	public static final String CODE_FLOAT = "12";

	public static final String CODE_INTEGER = "13";

	public static final String CODE_LONG = "14";

	public static final String CODE_SHORT = "15";
	
	public static final String CODE_IPADDRESS_INVALID = "16";
	
	public static final String CODE_UNKNOWN_ERROR = "17";
	
	// for page config
	// page
	public static final String PAGE_STYLE = "page.style";
	public static final String PAGE_TITLE = "page.title";
	public static final String COPY_RIGHT = "copy.right";
	public static final String PAGE_NAME = "page.name";
	public static final String LOGINPAGE_VALIDCODE= "loginpage.validcode";
	

	// footer page
	public static final String PAGE_FOOTERPAGE_VALID = "footerpage.valid";

	public static final String PAGE_DEFAULT_VALID_VALUE = "true";
	public static final String PAGE_DEFAULT_VALUE = "";
	// for controler
	public static final String CONTROLLER_CMD_ADD = "add";
	public static final String CONTROLLER_CMD_EDIT = "edit";
	public static final String CONTROLLER_CMD_UPDATE = "update";
	public static final String CONTROLLER_CMD_DEL = "del";
	public static final String CONTROLLER_CMD_LIST = "list";
	public static final String CONTROLLER_RETURN_MSG = "msg";
	public static final String CONTROLLER_RETURN_SUCCESS = "success";
	public static final String CONTROLLER_RETURN_TOTAL = "total";
	public static final String CONTROLLER_RETURN_RESULTLIST = "resultList";

	// for http prototal
	public static final String TRANSACTION_ID = "transactionid";
	public static final String CLIENT_ADDRESS = "clientaddress";
	public static final String KEY_COMMAND = "commond";
	
	//for dwz
	public static final String ROOTURLSTYLECLASS="rootUlStyleClass";
	public static final String IS_ATAG_CHECHBOX="isAtagCheckbox";
	public static final String BASE_URL_KEY="baseurl";
}
