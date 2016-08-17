package com.amazon.giant_cart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.giant_cart.model.Category;
import com.amazon.giant_cart.model.Supplier;

@Repository
public interface SupplierDAO {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier>  list();
}
