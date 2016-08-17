package com.amazon.giant_cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.giant_cart.model.Category;
@EnableTransactionManagement
@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionfactory) {
		
		this.sessionfactory = sessionfactory;
	}
	
	@Transactional
	public boolean save(Category category)
	{
	try
	{
		sessionfactory.getCurrentSession().save(category);
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
		
	}
	public boolean update(Category category)
	{
		try
		{
			sessionfactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public boolean delete(Category category)
	{
		try
		{
			sessionfactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public Category get(String id)
	{
		String hql = "from category where id = " + " ' " +  id + " ' ";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

	
	
	
	
	

}
