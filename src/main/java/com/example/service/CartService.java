package com.example.service;

import java.util.List;

import com.example.model.CartDTO;

public interface CartService {

	public List<CartDTO> cartMoney();
	public void insert(CartDTO dto);	// 장바구니 추가
	public List<CartDTO> listCart(String userid);	// 장바구니 목록
	public void delete(int cart_id);				// 장바구니 개별 삭제
	public void deleteAll(String userid);			// 장바구니 전체 삭제(비우기)
	public void update(int cart_id);
	public int sumMoney(String userid);				// 장바구니 금액 합계
	// 장바구니에 이미 상품이 담겼는지 확인
	public int countCart(String userid, int product_id);// 장바구니 상품 갯수
	// 장바구니 수량 변경 
	public void updateCart(CartDTO dto);			// 장바구니 수정
	public void modifyCart(CartDTO dto);
}
