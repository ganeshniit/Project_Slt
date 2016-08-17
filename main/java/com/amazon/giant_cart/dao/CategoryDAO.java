package com.amazon.giant_cart.dao;

import java.util.List;

import com.amazon.giant_cart.model.Category;

public interface CategoryDAO {
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category get(String id);
	public List<Category>  list();

}
