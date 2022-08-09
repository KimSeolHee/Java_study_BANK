package com.iu.start.member;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

//이 클래스는 Controller역할, 
//Container(생명주기를 관리해주는)에게 이 클래스의 객체를 생성 위임
@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	// annotation
	// @ : 설명 + 실행
	// /member/login 실행해야 하는 순수한 메서드를 만들어야함
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login"; //view화면에 연결해줌
	}
	
	//get
	//join /member/join → 절대경로로 작성해야함
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 Get 실행");
		
		return "member/join";
	}
	//post
	//public String join(String id, String pw, String name, String email, String phone) throws Exception
	//dto.setId(id);
	//dto.setPw(pw);
	//dto.setName(name);
	//dto.setEmail(email);
	//dto.setPhone(phone); 이런식으로 파라미터로 다 받아와서 이름만 쓰는 경우도 있다!!
//	@RequestMapping(value = "join", method = RequestMethod.POST)
//	public String join(HttpServletRequest re) throws Exception {
//		System.out.println("회원가입 Post 실행");
//		
//		BankMembersDAO dao = new BankMembersDAO();
//		BankMembersDTO dto = new BankMembersDTO();
//		dto.setId(re.getParameter("id"));
//		dto.setPw(re.getParameter("pw"));
//		dto.setName(re.getParameter("name"));
//		dto.setEmail(re.getParameter("email"));
//		dto.setPhone(re.getParameter("phone"));
//		
//		int result = dao.setJoin(dto);
//		
//		if(result == 1) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//	
//		return "member/join";
//	}
	
	
// 3번째 방법	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO BankMembersDTO) throws Exception {
		System.out.println("회원가입 Post 실행");
		
		BankMembersDAO dao = new BankMembersDAO();
		
		int result = dao.setJoin(BankMembersDTO);
		
		if(result == 1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	
		return "member/join";
	}

}
