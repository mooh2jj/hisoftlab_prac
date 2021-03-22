package com.example.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.ProductDTO;
import com.example.service.ProductService;

@RequestMapping("/product/**")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		model.addAttribute("list", productService.listProduct());
		
		return "product/product_list";
	}
	
	@RequestMapping("detail/{product_id}")
	public String detail(@PathVariable("product_id") int product_id,
			Model model) {
		
		model.addAttribute("dto", productService.detailProduct(product_id));
		
		return "product/product_detail";
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "product/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(ProductDTO dto) {
		
		String filename = "-";
		
		if(!dto.getFile1().isEmpty()) {	// 첨부파일이 존재하면
			filename = dto.getFile1().getOriginalFilename();
			String path = "I:\\JavaStudy\\JavaWeb Develement\\Spring\\test21\\hisoftlab_prac\\src\\main\\webapp\\resources\\images\\";
			
			try {
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path+filename));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		dto.setProduct_url(filename);
		productService.insertProduct(dto);
		
		return "redirect:/product/list.do";
	}
	
	@RequestMapping("edit/{product_id}")
	public String edit(@PathVariable("product_id") int product_id, Model model) {
		
		model.addAttribute("dto", productService.detailProduct(product_id));
		
		return "product/product_edit";
	}
	
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		System.out.println("dto: "+ dto);
		
		String filename = "-";
		
		if(!dto.getFile1().isEmpty()) {	// 첨부파일이 존재하면
			filename = dto.getFile1().getOriginalFilename();
			String path = "I:\\JavaStudy\\JavaWeb Develement\\Spring\\test21\\hisoftlab_prac\\src\\main\\webapp\\resources\\images\\";
			
			try {
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path+filename));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setProduct_url(filename);
		} else {
			ProductDTO dto2 = productService.detailProduct(dto.getProduct_id());
			dto.setProduct_url(dto2.getProduct_url());
		}
		
		productService.updateProduct(dto);
		
		return "redirect:/product/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		String filename = productService.fileInfo(product_id);
		
		if(filename != null && !filename.equals("-")) {		// 삭제할 때 첨부파일이 있을시!
			String path = "I:\\JavaStudy\\JavaWeb Develement\\Spring\\test21\\hisoftlab_prac\\src\\main\\webapp\\resources\\images";
			
			File f = new File(path+filename);
			
			if(f.exists()) {	// 파일이 존재하면 지워라!
				f.delete();
			}
		}
		
		productService.deleteProduct(product_id);
		
		return "redirect:/product/list.do";
	}
	
}
