package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.PdfService;

@RequestMapping("/pdf/*")
@Controller
public class PdfController {

	@Autowired
	PdfService pdfService;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		String result = pdfService.createPdf();
		model.addAttribute("message", result);
		
		return "pdf/result";
	}
}
