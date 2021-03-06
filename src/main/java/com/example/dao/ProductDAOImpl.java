package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> listProduct() {
		return sqlSession.selectList("product.list_product");
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne("product.detail_product", product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("product.update", dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		sqlSession.delete("product.delete", product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insert", dto);

	}

	@Override
	public String fileInfo(int product_id) {
		sqlSession.selectOne("product.file_info", product_id);
		return null;
	}

}
