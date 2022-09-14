//package com.iu.start.error;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
////예외처리를 전문으로 하는 컨트롤러
////전역으로 처리하는 방법
//@ControllerAdvice
//public class BackErrorController {
//
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView exceptionTest() {
//		ModelAndView mv = new ModelAndView();
//		
//		mv.setViewName("errors/error_404");
//		
//		return mv;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView exceptionTest2(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		
//		mv.setViewName("errors/error_404");
//		
//		return mv;
//	}
//}
