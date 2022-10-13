package com.hdsoft.coremailbridge.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class ServiceConfig {

	@Autowired
	Environment env;
	
	@Bean
	public RestTemplate restTemplate() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		List messageConverters = new ArrayList();
		MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJacksonHttpMessageConverter.setObjectMapper(objectMapper);
		messageConverters.add(new ByteArrayHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new ResourceHttpMessageConverter());
		messageConverters.add(new SourceHttpMessageConverter());
		messageConverters.add(new AllEncompassingFormHttpMessageConverter());
		messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(mappingJacksonHttpMessageConverter);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(httpRequestFactory());
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	private SimpleClientHttpRequestFactory httpRequestFactory() {
		SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(Integer.parseInt(this.env.getProperty("rest.connectTimeout")));
		httpRequestFactory.setReadTimeout(Integer.parseInt(this.env.getProperty("rest.readTimeout")));
		return httpRequestFactory;
	}

}
