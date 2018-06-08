package com.fm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fm.date.converter.DynamicDataSourceHolder;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return true;
		String requestUrl = request.getRequestURI();
		if(requestUrl.indexOf("roler")  > -1){
			DynamicDataSourceHolder.setDataSource("dataSource2");
			System.out.println("切换数据=====dataSource2" );
		}else {
			DynamicDataSourceHolder.setDataSource("dataSource");
			System.out.println("切换数据=====dataSource" );
		}
		 
		System.out.println("拦截器=====url" + requestUrl);
		return true;
	}
	//执行contoller后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	//进入视图渲染执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
