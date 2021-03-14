package com.example.dao;

import java.util.List;

import com.example.model.CartDTO;

public interface CartDAO {

	public List<CartDTO> cartMoney();
	public void insert(CartDTO dto);
	public List<CartDTO> listCart(String userid);
	public void delete(int cart_id);
	public void deleteAll(String userid);
	public void update(int cart_id);
	public int sumMoney(String userid);
	// 장바구니에 이미 상품이 담겼는지 확인
	public int countCart(String userid, int product_id);
	// 장바구니 수량 변경 
	public void updateCart(CartDTO dto);
	public void modifyCart(CartDTO dto);
}
