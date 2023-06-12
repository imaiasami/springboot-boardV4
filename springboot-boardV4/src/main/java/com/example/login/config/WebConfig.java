package com.example.login.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.login.filter.LoginCheckFilter;
import com.example.login.filter.TestFilter;
import com.example.login.interceptor.LoginCheckInterceptor;
import com.example.login.interceptor.TestInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Bean
	public FilterRegistrationBean<Filter> testFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		// 등록할 필터를 지정한다.
		filterRegistrationBean.setFilter(new TestFilter());
		// 필터의 순서를 등록
		filterRegistrationBean.setOrder(1);
		// 필터를 적용할 URL 패턴을 등록
		filterRegistrationBean.addUrlPatterns("/*");
		
		return filterRegistrationBean;
	}
	
//	@Bean
	public FilterRegistrationBean<Filter> loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		// 등록할 필터를 지정한다.
		filterRegistrationBean.setFilter(new LoginCheckFilter());
		// 필터의 순서를 등록
		filterRegistrationBean.setOrder(2);
		// 필터를 적용할 URL 패턴을 등록
		filterRegistrationBean.addUrlPatterns("/board/*");
		
		return filterRegistrationBean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터를 등록한다
		registry.addInterceptor(new TestInterceptor())
		// 인터셉터의 호출 순서 등록, 숫자가 낮을수록 먼저 실행
		.order(1)
		// 인터셉터를 적용할 URL 패턴을 지정
		.addPathPatterns("/**")
		// 인터셉터를 제외할 URL 패턴을 지정
		.excludePathPatterns("/*.css", "/*.js", "/css/**");
		
		registry.addInterceptor(new LoginCheckInterceptor())
		.order(2)
		.addPathPatterns("/**")
		.excludePathPatterns("/",  
				"/member/join",  
				"/member/login",
				"/member/checkId",
				"/*.css", 
				"/*.js");
	}
	
}













