package com.command.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 업로드 된 파일 저장 
		
		final String SAVE_URL = "ckupload"; 
		
		// 실제로 저장되는 물리적인 경로 
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath(SAVE_URL);
		System.out.println("업로드 경로 : " + saveDirectory);
		
		Enumeration names = null;
		String name = null; // 변수 준비 (parameter 로 넘어오는 name 값) 
		String originalFileName = null; // 원본파일 이름 
		String fileSystemName = null ; // 실제 저장된 파일 이름 
		String fileType = null; // 파일MIME타입
		String fileUrl = null; // 업로드 된 파일의 url
		
		int maxPostSize = 5 * 1024 *1024; //Post 받기 (최대 5M byte)
		String encoding = "utf-8"; // 인코딩
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = null;// ★★★
		
		try {
			multi = new MultipartRequest(
					request, 
					saveDirectory,
					maxPostSize,
					encoding,
					policy
				);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 1-2 
		names = multi.getFileNames();	// type="file" 요소의 name 들 추출들
		while(names.hasMoreElements()) {
			name = (String)names.nextElement();
			System.out.println("input name: " + name); // ckeditor 에서 name 은 "upload" 이다.
			
			originalFileName = multi.getOriginalFileName(name);
			fileSystemName = multi.getFilesystemName(name);
			fileType = multi.getContentType(name);
			
			fileUrl = request.getContextPath() + "/" + SAVE_URL + "/" + fileSystemName;
			System.out.println("fileUrl : " + fileUrl);
		}
		// 2. response (CK Editor 에서 정한 포맷으로, json ) 
// response sample
//		{
//		    "uploaded": 1,
//		    "fileName": "foo.jpg",
//		    "url": "/files/foo.jpg"
//		}
		
		String jsonString = "{\"filename\" : \"" + fileSystemName 
				+ "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
		
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // end execute()

} // end command
