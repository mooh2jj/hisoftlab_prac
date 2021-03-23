package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

	@RequestMapping("imageUpload.do")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile upload) throws Exception {
		System.out.println("imageUpload.do start...");
		// http header 설정
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 업로드한 파일 이름
		String fileName = upload.getOriginalFilename();
		// 바이트 배열로 변환
		byte[] bytes = upload.getBytes();
		// 이미지를 업로드할 디렉토리(배포 경로로 설정)
		String uploadPath = "I:\\JavaStudy\\JavaWeb Develement\\Spring\\test21\\hisoftlab_prac\\src\\main\\webapp\\resources\\images";
		
		OutputStream out = new FileOutputStream(
				new File(uploadPath + fileName));
		
		// 서버에 저장됨
		out.write(bytes);
		String callback = request.getParameter("CKEditorFuncNum");
		PrintWriter printWriter = response.getWriter();
		
		String fileUrl = request.getContextPath() + "/resources/images/" + fileName;
		System.out.println("fileUrl: " + fileUrl);
		
		printWriter.println(
				"<script>window.parent.CKEDITOR.tools.callFunction("
				+ callback+ ",'" + fileUrl + "','이미지가 업도르되었습니다.')"
				+ "</script>");
				// 스트림 닫기
				printWriter.flush();
		
	}
}
