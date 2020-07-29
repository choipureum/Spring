package com.kh.welcome.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.welcome.member.model.service.MemberService;
import com.kh.welcome.member.model.vo.Member;

//MemberController를 bean으로 등록

//Controller
//1. 사용자의 요청을 받아
//   어플리케이션에 알맞은 형태로 데이터를 파싱
//   적절한 Service의 메서드를 호출
//   Service로 부터 받은 결과값을 사용자에게 반환
  @Controller
  @RequestMapping("/member")
  public class MemberController {
	  
	  @Autowired   
	  public MemberService memberService;
	  
	/* @RequestMapping(value="/member/login.do")
	 	//해당 메서드를 어떤 url에 매핑 시킬 지 설정
	 	//value 속성을 사용해서 url 지정할 수 있다.
	 	//void : 요청이 온 url과 같은 경로의 jsp를 호출
	 public void logIn() {
	  	System.out.println("로그인 메서드 호출되었습니다.");
	 }*/
	  
	  //@RequestMapping("/login.do")
	  //RequestMapping에서 사용할 속성이 value밖에 없으면
	  //value 생략할 수 있다.
	  //class에 적용 : 모든 메서드에 적용되는 url경로 앞에 붙을 경로를 지정
	  //ModelAndView 객체의 setViewName 메서드의 파라미터로
	  //원하는 jsp경로를 입력해 jsp를 호출 할 수 있다.
	/*public ModelAndView logIn() {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/login");
	  System.out.println("로그인 메서드 호출되었습니다.");
	  return mav;
	}*/
	
	@RequestMapping(value="/login.do"
			, method=RequestMethod.GET)
	//@RequestMapping의 method 속성에 http method를 지정할 수 있다.
	//반환형이 String이라면 String의 값으로 jsp를 찾는다.
	public String login() {
		System.out.println("login 메서드 호출");
		return "/member/login";
	}
  
	@RequestMapping("/join.do")
	public void join() {}
	
	
	@RequestMapping("/joinimple.do")
	public ModelAndView joinImpl(
			//@RequestParam : Http요청 파라미터를 컨트롤러 메서드의 파라미터로 전달 받을 때 사용
			//타입을 자동으로 변환해준다.(ex. String -> int) 변경이 불가능한 경우 
			//400 responce code 응답
			//required : 필수 파라미터 여부 지정(default값은 true)
			//defaultValue : 필수 파라미터가 없을 경우 기본값으로 지정할 값을 설정
			//html 태그의 name 속성명과 컨트롤러의 파라미터 변수명을 일치시켜서 매핑
			
			//스프링 컨트롤러 매개변수 매핑Case
			// 메서드 매개변수와 HTML태그의 Name값이 같은 경우
			//Vo의 필드변수명과 HTML태그의 Name값이 같은경우(@ModelAttribute)
			//매서드 매개변수에 map을 지정한 경우
			// > HTML태그의 Name값이 Map의 Key값으로 저장
			// > 단 @RequestParam 어노테이션이 명시적으로 지정되어있어야한다.
				
			
			//HttpServletRequest
			//HttpServletResponse
			//HttpSession를 매개변수로 지정할 경우
			//DispatcherServlet이 해당객체를 전달해준다.
			
			
			//@ModelAttribute
			//1. html 태그의 name 속성명과 Commend 객체(Dto, Map<String,object>)의 
			//필드 변수명이 같은 경우
			//@RequestParam Map<String,Object> member				
			@ModelAttribute Member member,
			HttpServletRequest req
			) {
		String root= req.getContextPath();
		ModelAndView mav = new ModelAndView();
		int res = memberService.insertMember(member);
		if(res>0) {
			mav.addObject("alertMsg","회원가입에 성공");
			mav.addObject("url",root+"/member/login.do");
			mav.setViewName("/commons/result");
		}else {
			mav.addObject("alertMsg","회원가입 실패");
			mav.addObject("url",root+"/member/join.do");
			mav.setViewName("/commons/result");
		}

		return mav;
	}
	//로그인기능
	@RequestMapping(value="/loginimple.do")
	public ModelAndView loginImpl(@RequestParam Map<String,Object>commandMap,HttpSession session,
			HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		Member res = memberService.selectMember(commandMap);
		System.out.println(req.getContextPath());
		//로그인성공
		if(res!=null) {
			session.setAttribute("logInInfo",res);
			mav.addObject("alertMsg","로그인 성공");
			mav.addObject("url",req.getContextPath()+"/member/mypage.do");
		}
		else {
			mav.addObject("alertMsg","로그인 실패");
			mav.addObject("url",req.getContextPath()+"/member/login.do");
		}
		mav.setViewName("/commons/result");	
		return mav;
	}
	
	//마이페이지 GET
	@RequestMapping("/mypage.do")
	public void myPage() {}
  
	//마이페이지 수정하기	
	@RequestMapping("/modify.do")
	   public String modify(
	         //ModelAttribute 어노테이션 생략 가능
	         Member member
	         ,HttpSession session
	         //ModelAndView에서 값을 저장하는 Model객체
	         //view 경로를 지정하는 것은 return하는 String에 지정한다.
	         ,Model model
	         ) {
	      
	      Member sessionMember = (Member)session.getAttribute("logInInfo");
	      member.setUserId(sessionMember.getUserId());
	      int res = memberService.myPageUpdate(member);
	      
	      //회원 수정에 성공했다면
	      if(res > 0) {
	         //Model.addAttribute(K, V)
	         //: view에 전달할 데이터를 추가하는 메소드
	         model.addAttribute("alertMsg", "회원정보 수정 성공");
	         model.addAttribute("url", "mypage.do");
	         sessionMember.setPassword(member.getPassword());
	         sessionMember.setEmail(member.getEmail());
	         sessionMember.setTell(member.getTell());
	      }else {
	         model.addAttribute("alertMsg", "회원정보 수정 실패");
	         model.addAttribute("url", "mypage.do");
	      }
	      
	      return "common/result";
	   }
	
	//마이페이지 탈퇴하기 
	// 회원 탈퇴 post
		@RequestMapping(value="/leave.do", method = RequestMethod.POST)
		public ModelAndView memberDelete(@ModelAttribute Member member, HttpSession session, HttpServletRequest req) throws Exception{
			ModelAndView mav = new ModelAndView();
			
			int res= memberService.myPageDelete(member);
			if(res>0) {
				session.invalidate();
				mav.addObject("alertMsg","탈퇴 성공");
				mav.addObject("url",req.getContextPath()+"/member/login.do");
			}else {
				mav.addObject("alertMsg","탈퇴 실패");
				mav.addObject("url",req.getContextPath()+"/member/mypage.do");
			}
			mav.setViewName("/commons/result");				
			return mav;
		}
		
		//아이디 중복확인 AJAX
		@RequestMapping(value="/idcheck.do", method=RequestMethod.POST)
		@ResponseBody     //메소드에@ResponseBody 어노테이션을 지정하면 메서드에서 반환되는 값을
						//viewResolver를 거쳐서 출력하지 않고 HttpResponse Body에 직접 쓰게된다
		public String idCheck(String userId) {
			 int res = memberService.selectId(userId);
		      if(res>0) {
		         return userId;
		      }else {
		         return"";
		      }
		   }
		

  }
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
