package com.hdsoft.coremailbridge.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
    
    @Value(value = "${handian.server.basepath}")
	private String serverDomain;
    
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		if (StringUtils.isEmpty(serverDomain)) {
			String path = httpServletRequest.getContextPath();
			String scheme = httpServletRequest.getScheme();
			String serverName = httpServletRequest.getServerName();
			int port = httpServletRequest.getServerPort();
			String basePath = scheme + "://" + serverName + ":" + port + path;
			httpServletRequest.setAttribute("basePath", basePath);
			logger.debug("add basePath attribute. basePath : {}", basePath);
		}
		else {
			httpServletRequest.setAttribute("basePath", serverDomain);
			logger.debug("add basePath attribute. basePath : {}", serverDomain);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
