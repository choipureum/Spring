package com.kh.welcome.board.model.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.welcome.board.model.dao.NoticeDao;
import com.kh.welcome.board.model.vo.Notice;

import common.util.FileUtil;
import common.util.Paging;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	//게시글 삽입
	public int insertNotice(Notice notice,List<MultipartFile>files,String root) {
		int result = noticeDao.insertNotice(notice);
		//파일이 존재할때
		if(!(files.size()==1 && files.get(0).getOriginalFilename().equals(""))) {
			//파일 업로드를 위해 FileUtil.fileupload()호출
			List<Map<String,String>> filedata = new FileUtil().fileupload(files,root);
			
			for(Map<String,String>f:filedata) {
				noticeDao.insertFile(f);
			}
		}
		return result;
	}
	//게시글 전체조회
	public Map<String,Object> selectNoticeList(
			//현재페이지와 페이지당 노출할 게시글 수는 따로 받아와야함
			int currentPage, int cntPerPage){
		Map<String,Object>commandMap = new HashMap<String, Object>();
		
		//페이징 처리를 위한 객체생성
		Paging paging = new Paging(noticeDao.selectContentCnt(),currentPage,cntPerPage);
		//페이지에 필요한 Notice 리스트 받아오기
		List<Notice> nlist = noticeDao.selectNoticeList(paging);
		commandMap.put("nlist",nlist);
		commandMap.put("paging", paging);
		
		return commandMap;
	}
	//게시글 상세조회
	public Map<String,Object> selectNoticeDetail(int nIdx){
		Map<String,Object>commandMap = new HashMap<String, Object>();
		//Notice 게시글 받아오기
		Notice notice = noticeDao.selectNoticeDetail(nIdx);
		//파일정보 받아오기
		List<Map<String,String>> flist = noticeDao.selectFileWithNotice(nIdx);
		commandMap.put("notice", notice);
		commandMap.put("flist", flist);
		return commandMap;
	}	
	//파일 조회 -> 삭제
	public void deleteFile(int fIdx, HttpSession session){		
		Map<String, String> flist = noticeDao.selectFile(fIdx);
		String filename = flist.get("renameFileName");
	    String readFolder = session.getServletContext().getRealPath("/resources/upload/")+filename;	     
	    File file = new File (readFolder);	
	   
	    if(file.exists()) {
	    	System.out.println("파일삭제됨");
	 	    file.delete();   
	    }else {
	    	System.out.println("파일없음");
	    }
	       
		noticeDao.deleteFileIdx(fIdx);
	}
	//게시물 업데이트
	public int updateNotice(Notice notice,List<MultipartFile> files,String root
            ) {
         int result = noticeDao.updateNotice(notice);
         int nIdx = notice.getnIdx();
         if(!(files.size() == 1
               && files.get(0).getOriginalFilename().equals("") )) {
               
            //파일업로드를 위해 FileUtil.fileUpload() 호출
            List<Map<String,String>> filedata 
               = new FileUtil().fileupload(files, root);
            
            for(Map<String,String> f : filedata) {
               System.out.println(f);
               noticeDao.updateInsertFile(f,nIdx);
            }                     
         }         
        return result;
      }
}
















