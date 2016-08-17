package com.amazon.giant_cart.test;

//import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.giant_cart.dao.CategoryDAO;
import com.amazon.giant_cart.dao.CategoryDAOImpl;
import com.amazon.giant_cart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.amazon");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		Category category=(Category)context.getBean("category");
		category.setId("CT_001");
		category.setName("Electronics");
		category.setDescription("Electronics Category");
	
		if (categoryDAO.save(category)==true)
		{
			System.out.println("Category Entry Was Successfull");
		}
		else 
		{
			System.out.println("Category Entry Was not Successfull");
		}
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.amazon");
		context.refresh();
		SessionFactory f=(SessionFactory)context.getBean("CategoryDAO");
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		Category category=new Category();
		category.setId("CT_001");
		category.setName("Electronics");
		category.setDescription("Electronics Section");
		
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
		
		
		s.save(category);
		//StudentInfo st = (StudentInfo)s.get(StudentInfo.class, 100);
		tx.commit();
		s.close();
		System.out.println("Values Are Entered");*/
		
	}

	}


