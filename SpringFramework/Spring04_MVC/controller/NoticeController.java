package com.kh.welcome.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	@RequestMapping(value="board/boardForm.do",method=RequestMethod.GET)
	public String boardForm() {
		return "board/boardForm";
	}
	
	@RequestMapping(value="notice/noticeupload.do",method=RequestMethod.POST)
	// 다중 파일 업로드임으로 여러개의 MultipartFile을 담기위한  List생성
	public ModelAndView noticeUpload(@RequestParam List<MultipartFile>files, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//파일 업로드를 위한 절대경로 반환
		String root = session.getServletContext().getRealPath("/");
		// MultipartFile 예외처리
		// 	>>사용자가 파일업로드를 하지 않았을때
		//	사용자가 첨부한 파일이 없어도 List<MultipartFile> 의 size()가 1로잡힌다.
		//	이대 첨부한 파일의 이름은  공백이다.(파일이 없을때)
		if(!(files.size()==1 && files.get(0).getOriginalFilename().equals(""))) {
			for(MultipartFile mf: files) {
				//파일을 저장할 경로
				String savePath = root+"resources/upload";
				System.out.println(savePath);
				//transferTo 메서드의 매개변수에 넣어줄 
					// 빈 파일 객체를 저장할 경로 + 사용자가 등록한 파일 이름으로 생성
				File fileData = new File(savePath+"/"+mf.getOriginalFilename());
				try {
					//빈 파일 객체에 사용자가 등록한 파일을 덮어쓴다.
					mf.transferTo(fileData);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}	
		//혹시 경로 root가 다르게 출력될경우 프로젝트 설정 -> properties -> development access의 root경로 필요없는 걸 삭제해준다.
		return mav;
		
	}
	
}















