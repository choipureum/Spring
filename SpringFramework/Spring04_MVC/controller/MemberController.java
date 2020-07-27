package com.kh.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.member;

@Controller
//Controller 어노테이션으로 해당 객체를 WebApplicationContext에 등록
// Controller 어노테이션을 등록함으로써 @RequestParam, @RequestMapping
// 같은 Controller를 위한 어노테이션을 사용할 수 있다.
@RequestMapping("/member")
public class MemberController {
   
//   @RequestMapping("/join.do")
//   //해당 메서드를 어떤 url에 매핑 시킬 지 설정
//   //value 속성에 url을 지정할 수 있다. 단 지정할 속성이 value밖에 없다면 생략 가능하다.
//   public void join() {
//      //void : 컨트롤러에서 return type이 void라면 요청온 url과 동일한 
//      //      jsp를 찾아서 사용자에게 보내준다.
//   }
   
//   @RequestMapping("/join.do")
//   //RequestMapping을 class에 적용하면 해당 클래스의 모든 메서드 적용되는
//   //url을 지정하실 수 있습니다. 이 url 메서드에 붙는  url 앞 경로를 의미합니다.
//   public String join() {
//      //String이 반환형이면 String으로 반환되는 문자열이 jsp의 경로가 된다.
//      return "/member/join";
//   }
   
   @RequestMapping(value="/join", method=RequestMethod.GET)
   //value에 url, method 속성에 허가할 http method 방식 지정
   //만약 method 속성을 작성하지 않음녀 get, post 둘 다 허용한다.
   public ModelAndView join() {
      //ModelAndView : model 객체에 값을 담고
      //viewName을 보내고 싶은 jsp의 경로로 지정
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/member/join");
      return mav;
   }
   
   @RequestMapping("/login")
   public void login() {}   
   
   @RequestMapping("/joinimpl")
   public ModelAndView joinImpl(
         //@RequestParam : http 요청 파라미터를 컨트롤러 메서드의 파라미터로 전달 받음
         //때 사용한다.
         //타입을 자동으로 변환해준다(매개변수의 타입을 int로 지정했다면 String을 int로 변환
         //단 변경이 불간으한 경우에는 400 응답코드를 반환한다.
      
         //ModelAttribute
         //vo에 http 요청 파라미터를 전달할 때 사용하는 annotation
         //html 태그의 name 속성값과 vo의 필드변수명이 일치해야 mapping이 이루어 진다.
         //@RequestParam Map<String,Object> commandMap
         @ModelAttribute member member
         ) {
	   	 ModelAndView mav = new ModelAndView();
         System.out.println(member);
         mav.setViewName("/member/login");
      
      return mav;
   }
   
   

}
