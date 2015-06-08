package com.itdeepdive.mvc.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.itdeepdive.user.controllers.WebSocketController;
import com.itdeepdive.websocket.config.WebSocketConfig;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {WebSocketController.class})
@Import(WebSocketConfig.class)
public class SpringWebMVCConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}
}
