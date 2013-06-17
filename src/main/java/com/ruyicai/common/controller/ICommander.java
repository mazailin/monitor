package com.ruyicai.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ICommand
 * 
 * @author TIAN ShangJun
 */
public interface ICommander {
	void  execute(HttpServletRequest request, HttpServletResponse response);
	
}
