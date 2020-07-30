package com.kh.welcome.book;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	 /**
     * @RequestBody
     * HTTP Request Message 의 body 부분에 들어있는 데이터를 그대로 전달해준다
     * request header 에 Content-type 을 application/json
     * 으로 지정하면 해당 json을 자바의 객체로 변환하여 넣어준다
     * 
     */
	
   @RequestMapping("jacksoncore.do")
   public String kakaoBook(@RequestBody Map<String, Object> kakaoBook) {
         
	   	List <Map<String,Object>> jsonData =(List<Map<String,Object>>) kakaoBook.get("documents");
        
	   	for(Map<String,Object> e: jsonData) {
	   		System.out.println(e);
	   		System.out.println(e.get("authors"));
	   	}
	   	
	   	return "member/join";

   }
   
   
   
}
