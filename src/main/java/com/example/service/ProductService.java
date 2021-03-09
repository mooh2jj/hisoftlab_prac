package com.example.service;

import java.util.List;

import com.example.model.ProductDTO;

public interface ProductService {

	List<ProductDTO> listProduct();
	ProductDTO detailProduct(int product_id);
	String fileInfo(int product_id);
	void updateProduct(ProductDTO dto);
	void deleteProduct(int product_id);
	void insertProduct(ProductDTO dto);
}
