package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.CartDTO;
import com.example.service.CartService;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	CartService cartService;
	
	@RequestMapping("insert.do")
	public String insert(CartDTO dto, HttpSession session) {
		
		String userid = (String)session.getAttribute("userid");
		
		if(userid == null) {	// 로그인 안한 상태면 다시 로그인화면으로!
			return "redirect:/member/login.do";
		}
		dto.setUserid(userid);
		cartService.insert(dto);
		
		return "redirect:/cart/list.do";
	}
	
	@RequestMapping("list.do")
	public String list(HttpSession session, Model model) {
		
		Map<String, Object> map = new HashMap<>();
		
		String userid = (String) session.getAttribute("userid");
		
		if(userid != null) {	// 로그인 한 경우
			List<CartDTO> list = cartService.listCart(userid);
			System.out.println("list: "+ list);
			// 장바구니 금액 합계
			int sumMoney = cartService.sumMoney(userid);
			System.out.println("sumMoney: " + sumMoney);
			// 3만원 이상이면 배송료 면제
			int fee = sumMoney >= 30000 ? 0 : 2500;
			
			map.put("sumMoney", sumMoney);
			map.put("fee", fee);	// 배송료
			map.put("sum", sumMoney + fee);	// 전체 금액
			map.put("list", list);	// 장바구니 목록
			map.put("count", list.size());	// 레코드 갯수
			
			model.addAttribute("map", map);
			return "cart/cart_list";
			
		} else {	// 로그인하지 않은 경우
			return "member/login";
		}

	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id) {
		cartService.delete(cart_id);
		return "redirect:/cart/list.do";
	}
	
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		System.out.println("deleteAll.do start...");
		
		String userid = (String)session.getAttribute("userid");
		if(userid != null) {
			cartService.deleteAll(userid);
		}
		return "redirect:/cart/list.do";
	}
	
	@RequestMapping("update.do")
	public String update(int[] amount, int[] cart_id, HttpSession session) {
		System.out.println("update.do start...");
		
		String userid = (String)session.getAttribute("userid");
		
		for(int i =0; i <cart_id.length; i++) {
			if(amount[i] == 0) {
				cartService.delete(cart_id[i]);
			}else {
				CartDTO dto =new CartDTO();
				dto.setUserid(userid);
				dto.setCart_id(cart_id[i]);
				dto.setAmount(amount[i]);
				cartService.modifyCart(dto);
			}
		}
		return "redirect:/cart/list.do";
	}
	
}
