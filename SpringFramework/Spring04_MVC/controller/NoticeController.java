package com.kh.welcome.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.board.model.service.NoticeService;
import com.kh.welcome.board.model.vo.Notice;
import com.kh.welcome.member.model.vo.Member;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/board/boardForm.do",method=RequestMethod.GET)
	public String boardForm() {
		return "board/boardForm";
	}
	
	@RequestMapping(value="/notice/noticeupload.do",method=RequestMethod.POST)
	// 다중 파일 업로드임으로 여러개의 MultipartFile을 담기위한  List생성
	public ModelAndView noticeUpload(@RequestParam List<MultipartFile>files, HttpSession session, Notice notice) {
		ModelAndView mav = new ModelAndView();
		//파일 업로드를 위한 절대경로 반환
		// MultipartFile 예외처리
		// 	>>사용자가 파일업로드를 하지 않았을때
		//	사용자가 첨부한 파일이 없어도 List<MultipartFile> 의 size()가 1로잡힌다.
		//	이대 첨부한 파일의 이름은  공백이다.(파일이 없을때)
		
		String root = session.getServletContext().getRealPath("/");
		Member sessionMember = (Member)session.getAttribute("logInInfo");
		
		//로그인한 상태라면
		if(sessionMember!=null) {
			notice.setUserId(sessionMember.getUserId());			
		}
		//비로그인
		else {
			notice.setUserId("비회원");
		}
		noticeService.insertNotice(notice, files, root);
		//브라우저는 바로 응답코드로 보낸다
			//notice/noticelist.do로 다시요청
		mav.setViewName("redirect:/notice/noticelist.do");
		//혹시 경로 root가 다르게 출력될경우 프로젝트 설정 -> properties -> development access의 root경로 필요없는 걸 삭제해준다.
		return mav;	
	}
	
	@RequestMapping(value="/notice/noticelist.do")
	//cPage는 필수항목이 아니며 없을때는 1이들어감
	public ModelAndView noticeList(@RequestParam(required = false,defaultValue = "1") int cPage) {
		ModelAndView mav = new ModelAndView();
		//페이지당 10개게시글 보기
		int cntPerPage=10;
		Map<String,Object>commandMap = noticeService.selectNoticeList(cPage, cntPerPage);
		//페이징 객체를 보낸다
		mav.addObject("paging",commandMap.get("paging"));
		mav.addObject("noticeData",commandMap);
		mav.setViewName("board/boardList");
		return mav;
	}
	//상세보기
	@RequestMapping(value="/notice/noticedetail.do")
	public ModelAndView noticeDetail(int nIdx) {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> commanMap = noticeService.selectNoticeDetail(nIdx);
		//해당 게시물 존재여부 판단
			//반환되는 Map 자체는 null일 수 없다 //Map안의 notice 객체가 null인지 여부로 판단
		//게시물이 존재할때
		if(commanMap.get("notice")!=null) {
			mav.addObject("data",commanMap);
			mav.setViewName("board/boardView");
		}
		//게시물이 없을때
		else {
			mav.addObject("alertMsg","해당게시물이 존재하지 않습니다");
			mav.addObject("url","board/boardList");
			mav.setViewName("common/result");
		}	
		return mav;
	}
}









