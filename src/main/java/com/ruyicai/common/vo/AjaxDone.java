package com.ruyicai.common.vo;
/**navTabAjaxDone是DWZ框架中预定义的表单提交回调函数．
* 服务器转回navTabId可以把那个navTab标记为reloadFlag=1, 下次切换到那个navTab时会重新载入内容. 
* callbackType如果是closeCurrent就会关闭当前tab
* 只有callbackType="forward"时需要forwardUrl值
* navTabAjaxDone这个回调函数基本可以通用了，如果还有特殊需要也可以自定义回调函数.
*/
public class AjaxDone {
	private String statusCode; //200
	private String message;
	private String navTabId;
	private String forwardUrl;
	private String callbackType="closeCurrent";
	private String rel;

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
}
