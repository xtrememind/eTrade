package edu.mum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.mum.domain.User;


public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if(user== null)
			return true;
		if(user.getUserCredentials().getAuthority().isEmpty())
			return true;
		if(user.getUserCredentials().getAuthority().get(0).getAuthority().equals("ROLE_USER")) {
			response.sendRedirect("/eTrade/access403");
			return false;
		}
		
		return true;
	}
	
}
