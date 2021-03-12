package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
