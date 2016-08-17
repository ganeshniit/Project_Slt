package com.amazon.giant_cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.giant_cart.model.Category;
import com.amazon.giant_cart.model.UserDetails;
@EnableTransactionManagement
@Repository(value="UserDetailsDAO")

public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
private SessionFactory sessionfactory;

	public UserDetailsDAOImpl(SessionFactory sessionfactory) {
	super();
	this.sessionfactory = sessionfactory;
}
	@Transactional
	public boolean save(UserDetails userDetails) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(userDetails);

		return false;
	}

	public boolean update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(userDetails);
		return false;
	}

	public boolean delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(userDetails);
		return false;
	}

	public UserDetails get(String id) {
		String hql = "from UserDetails where id = " + " ' " +  id + " ' ";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<UserDetails> list() {
		String hql = "from UserDetails";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}



	
}
