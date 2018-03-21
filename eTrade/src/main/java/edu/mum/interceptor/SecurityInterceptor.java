package edu.mum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("intercepting.");
		HttpSession session = request.getSession(false);
		System.out.println("session == "+session );
		if(session==null || session.getAttribute("userId")==null) {
			
			System.out.println("should redirect to login");
			response.sendRedirect("/eTrade/login");
			return false;
		}
		System.out.println("success");
		return true;
	}

}