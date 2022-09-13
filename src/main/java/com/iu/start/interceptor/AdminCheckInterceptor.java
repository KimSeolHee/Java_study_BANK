package com.iu.start.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.member.BankMembersDTO;
import com.iu.start.member.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		//1.  
		BankMembersDTO bankmembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");
		
		boolean check=false;
		for(RoleDTO roleDTO : bankmembersDTO.getRoleDTOs()) {
			roleDTO.getRoleNum();
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		//admin이 아닐 때 
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result"); //jsp의 경로
			view.forward(request, response);
		}
		
		return check;
	}

}
