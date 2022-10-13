package com.hdsoft.coremailbridge.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogInterceptor implements HandlerInterceptor {

	private final static String REQUEST_ID = "requestId";
	private final static String REMOTEIP = "remoteIp";
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		// String xForwardedForHeader = httpServletRequest.getHeader("X-Forwarded-For");
		String remoteIp = httpServletRequest.getRemoteAddr();
		String uuid = UUID.randomUUID().toString();
		MDC.put(REQUEST_ID, uuid);
		MDC.put(REMOTEIP, remoteIp);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
//		String uuid = MDC.get(REQUEST_ID);
//		String remoteIp = MDC.get(REMOTEIP);
		MDC.remove(REQUEST_ID);
		MDC.remove(REMOTEIP);
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
