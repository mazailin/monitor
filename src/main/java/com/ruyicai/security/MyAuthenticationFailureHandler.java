package com.ruyicai.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import com.ruyicai.systemmanage.domain.User;
import com.ruyicai.systemmanage.service.UserService;

public class MyAuthenticationFailureHandler implements
		AuthenticationFailureHandler {
	protected final Log logger = LogFactory.getLog(getClass());

	public MyAuthenticationFailureHandler() {
		super();
	}

	public MyAuthenticationFailureHandler(String defaultFailureUrl) {
		setDefaultFailureUrl(defaultFailureUrl);
	}

	public final static String TRY_MAX_COUNT = "tryMaxCount";
	private int maxTryCount = 3;
	private boolean forwardToDestination = false;
	private boolean allowSessionCreation = true;
	private String defaultFailureUrl;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Resource
	private UserService userService;

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// super.onAuthenticationFailure(request, response, exception);
		HttpSession session = request.getSession();

		Integer tryCount = (Integer) session.getAttribute(TRY_MAX_COUNT);
		System.out.println("tryCount="+tryCount);
//		session.setAttribute("authenticationFail", "yes");
		if (tryCount == null) {
			session.setAttribute(TRY_MAX_COUNT, 1);// 增加失败次数
			
		} else {
			if (tryCount > maxTryCount - 1) {
				// 锁定账户

//				String name = request
//						.getParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY);
//				User user = userService.findByName(name);
//
//				if (user != null) {
//					user.setState(1);
//					user.setFailedLoginAttempts(tryCount);
//					userService.update(user);
//				}
//
//				exception=new MaxTryLoginException("超过最大登录尝试次数" + maxTryCount
//								+ ",用户已被锁定");
			}
			session.setAttribute(TRY_MAX_COUNT, tryCount+1 );
		}

		// 觉得默认跳转的地方
		if (defaultFailureUrl == null) {
			logger.debug("No failure URL set, sending 401 Unauthorized error");

			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Authentication Failed: " + exception.getMessage());
		} else {
			saveException(request, exception);

			if (forwardToDestination) {
				logger.debug("Forwarding to " + defaultFailureUrl);

				request.getRequestDispatcher(defaultFailureUrl).forward(
						request, response);
			} else {
				logger.debug("Redirecting to " + defaultFailureUrl);
				redirectStrategy.sendRedirect(request, response,
						defaultFailureUrl);
			}
		}

	}

	/**
	 * The URL which will be used as the failure destination.
	 * 
	 * @param defaultFailureUrl
	 *            the failure URL, for example "/loginFailed.jsp".
	 */
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl), "'"
				+ defaultFailureUrl + "' is not a valid redirect URL");
		this.defaultFailureUrl = defaultFailureUrl;
	}

	/**
	 * Caches the {@code AuthenticationException} for use in view rendering.
	 * <p>
	 * If {@code forwardToDestination} is set to true, request scope will be
	 * used, otherwise it will attempt to store the exception in the session. If
	 * there is no session and {@code allowSessionCreation} is {@code true} a
	 * session will be created. Otherwise the exception will not be stored.
	 */
	protected final void saveException(HttpServletRequest request,
			AuthenticationException exception) {
		if (forwardToDestination) {
			request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
					exception);
		} else {
			HttpSession session = request.getSession(false);

			if (session != null || allowSessionCreation) {
				request.getSession().setAttribute(
						WebAttributes.AUTHENTICATION_EXCEPTION, exception);
			}
		}
	}
}
