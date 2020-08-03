package common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
	
	public List<Map<String,String>>fileupload(List<MultipartFile>files,String root){
		//파일과 관련된 정보를 가지고 반환될 list
		List<Map<String,String>> fileData = new ArrayList<Map<String,String>>();
		
		//rename 뒤에 붙여줄 index
		int idx=0;
				
		for(MultipartFile mf: files) {
			System.out.println(root);
			String savePath = root+"resources/upload/";
			//사용자가 올린 이름
			String originFileName=mf.getOriginalFilename();
			String renameFileName=getRenameFileName(originFileName, idx);
			
			savePath+=renameFileName;
			Map<String,String> map = new HashMap<String,String>();
			map.put("originFileName",originFileName);
			map.put("renameFileName", renameFileName);
			map.put("savePath", savePath);
			//tb_file에 등록할 데이터를  list에 추가
			fileData.add(map);
			// 사용자가 등록한 파일을 파일저장경로에 저장
			saveFile(mf,savePath);
			// 파일명 변경을 위한 인덱스값 증가
			idx++;
		}	
		return fileData;
	}
	
	public String getRenameFileName(String originFileName, int idx) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//밀리초 단위 날짜 + 인덱스 + 확장자 .
		String renameFileName = sdf.format(new Date(System.currentTimeMillis()))+idx+"."+originFileName.substring(originFileName.lastIndexOf(".")+1);
		return renameFileName;
		
	}
	public void saveFile(MultipartFile mf, String savePath) {
		//사용자가 등록한 파일을 옮겨담을 파일 객체 생성
		//savePath : 저장할 경로 + 변경된 파일명
		File fileData = new File(savePath);
		try {
			mf.transferTo(fileData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteFile(String path) {
		//지정된 경로의 파일 객체를 생성하고 delete메서드실행
		File file = new File(path);
		file.delete();
	}
}



















