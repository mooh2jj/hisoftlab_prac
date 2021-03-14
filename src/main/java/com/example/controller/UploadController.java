package com.example.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload/**")
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name = "uploadPath")
	String uploadPath;

	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public String uploadForm() {
		return "upload/uploadForm";
	}

	@RequestMapping(value = "uploadFormSet", method = RequestMethod.POST)
	public String uploadFileSet(MultipartFile file, Model model) throws Exception {

		String savedName = "";
		savedName = new String(file.getOriginalFilename().getBytes("8859_1"), "UTF-8");		// 한글깨짐 방지
		
		logger.info("originalName: " + savedName);
		logger.info("size:" + file.getSize());
		logger.info("contentType:" + file.getContentType());

		savedName = uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		model.addAttribute("savedName", savedName);

		return "upload/uploadResult";
	}

	// 파일 이름이 중복되지 않도록 처리
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {

		UUID uuid = UUID.randomUUID(); // 범용고유 식별자, universally unique identifier

		String savedName = uuid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName); 
		// 임시디렉토리에 저장된 업로드된 파일을
		// 지정된 디렉토리로 복사
		// FileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(fileData, target); // FileCopyUtils.copy(inputStream in, outputStream out)

		return savedName;
	}
}
