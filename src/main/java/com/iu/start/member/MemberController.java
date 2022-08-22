package com.iu.start.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankAccount.BankAccountService;
import com.iu.start.bankBook.BankBookDTO;

//이 클래스는 Controller역할, 
//Container(생명주기를 관리해주는)에게 이 클래스의 객체를 생성 위임
@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private BankMembersService bankMembersService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	@RequestMapping(value="myPage.do", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
//		mv.addObject("map", map);
		
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
//		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
//		mv.addObject("list", ar);
	    mv.addObject("dto", bankMembersDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "Logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect: ../";
	}
	
	@RequestMapping(value = "search.do", method = RequestMethod.GET)
	public void getSearchById() {
		System.out.println("search 실행");
	}
	
// 2번째 방법	
//	@RequestMapping(value = "search", method = RequestMethod.GET)
//	public ModelAndView getSearchById() {
//		System.out.println("search 실행");
//		ModelAndView mv = ModelAndView();
//		mv.setViewName("member/search");
//		
//		return mv;
//	}
	
	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public String getSearchById(Model model, String id) throws Exception {
		System.out.println("search-post 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchById(id);
		if(ar.size() != 0) {
			model.addAttribute("list", ar);			
		}else {
			return "member/null";
		}
		
		return "member/list";
	}

//2번째 방법
//	@RequestMapping(value = "search", method = RequestMethod.POST)
//	public ModelAndView getSearchById(String id) throws Exception {
//		System.out.println("search-post 실행");
//		BankMembersDAO dao = new BankMembersDAO();
//		ModelAndView mv = new ModelAndView();
//		ArrayList<BankMembersDTO> ar = dao.getSearchById(id);
//
//		mv.setViewName("member/list");
//		mv.addObject("list", ar);
//	
//		return mv;
//	}
	
	
	// annotation
	// @ : 설명 + 실행
	// /member/login 실행해야 하는 순수한 메서드를 만들어야함
	@RequestMapping(value = "login.do")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login"; //view화면에 연결해줌
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO dto) throws Exception {
		System.out.println("로그인 실행-post");
		dto = bankMembersService.getLogin(dto);
		if(dto != null) {
			System.out.println("성공");
		}else if(dto == null) {
			System.out.println("실패");
		}
		
		//session은 일정시간동안 살아있음! 로그인 할땐 session을 이용해야함.
//		HttpSession session = request.getSession(); session을 매개변수로 받으면 생략가능
		session.setAttribute("member", dto);
		
//		model.addAttribute("member", dto); 이전에 했던 방법
		//"rediect: 다시접속할 URL주소(절대경로, 상대경로)"
		return "redirect: ../";
	}
	
	//get
	//join /member/join → 절대경로로 작성해야함
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
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
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String join(BankMembersDTO BankMembersDTO) throws Exception {
		System.out.println("회원가입 Post 실행");
		
		int result = bankMembersService.setJoin(BankMembersDTO);
		
		if(result != 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	
		return "redirect: ../";
	}

}
