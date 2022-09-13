package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.member.BankMembersDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			return;
		}
		//로그인 사용자 정보
		BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");
		
		//DTO
		Map<String, Object> map = modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO) map.get("boardDTO");
		
		if(!bankMembersDTO.getId().equals(boardDTO.getWriter())) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("result", 1);
			modelAndView.addObject("message", "작성자만 수정이 가능");
			modelAndView.addObject("url", "./list.do");
		}
	}

}
