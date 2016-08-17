package com.amazon.giant_cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.giant_cart.model.Product;
import com.amazon.giant_cart.model.UserDetails;
@EnableTransactionManagement
@Repository(value="ProductDAO")

public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	
	
	public ProductDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}
	@Transactional
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(product);

		return false;
	}
	@Transactional
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(product);
		return false;
	}
	@Transactional
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(product);
		return false;
	}
	@Transactional
	public Product get(String id) {
		String hql = "from Product where id = " + " ' " +  id + " ' ";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}
	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
}
