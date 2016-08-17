package com.amazon.giant_cart.dao;

import java.util.List;

import com.amazon.giant_cart.model.Product;

//import com.amazon.giant_cart.model.ProductDetails;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product get(String id);
	public List<Product>  list();

	
	
}
