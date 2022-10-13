package com.hdsoft.coremailbridge.config;

import com.hdsoft.coremailbridge.interceptor.CommonInterceptor;
import com.hdsoft.coremailbridge.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
    private LogInterceptor logInterceptor;
	@Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
