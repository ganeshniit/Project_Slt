package com.amazon.giant_cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.giant_cart.model.Supplier;
import com.amazon.giant_cart.model.UserDetails;

@EnableTransactionManagement
@Repository(value="SupplierDAO")


public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	
	
	public SupplierDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(supplier);
		return false;
	}

	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(supplier);
		return false;
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(supplier);
		return false;
	}

	public Supplier get(String id) 
		{
			String hql = "from Supplier where id = " + " ' " +  id + " ' ";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			if(list == null)
		    {
		    	return null;
		    }
			else
		    {
		    	return list.get(0);
		    }
			
		
		
		}

		public List<Supplier> list() {
			String hql = "from Supplier";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();
		}



}
