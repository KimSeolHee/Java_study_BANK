package com.iu.start.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//이 클래스는 Controller역할, 
//Container(생명주기를 관리해주는)에게 이 클래스의 객체를 생성 위임
@Controller 
public class MemberController {
	
	// annotation
	// @ : 설명 + 실행
	// /member/login 실행해야 하는 순수한 메서드를 만들어야함
	@RequestMapping(value = "/member/login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	//join /member/join
	@RequestMapping(value = "/member/join")
	public String join() {
		System.out.println("회원가입 실행");
		
		return "member/join";
	}

}
