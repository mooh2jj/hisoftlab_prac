package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<CartDTO> cartMoney() {
		return sqlsession.selectList("cart.cart_money");
	}

	@Override
	public void insert(CartDTO dto) {
		sqlsession.insert("cart.insert", dto);

	}

	@Override
	public List<CartDTO> listCart(String userid) {
		
		return sqlsession.selectList("cart.listCart", userid);
	}

	@Override
	public void delete(int cart_id) {
		sqlsession.delete("cart.delete", cart_id);
	}

	@Override
	public void deleteAll(String userid) {
		sqlsession.delete("cart.deleteAll", userid);

	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int sumMoney(String userid) {
		return sqlsession.selectOne("cart.sumMoney", userid);
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyCart(CartDTO dto) {
		sqlsession.update("cart.modifyCart", dto);

	}

}
