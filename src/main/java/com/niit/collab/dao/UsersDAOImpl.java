package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO

{
	
	@Autowired
	
	private SessionFactory sessionFactory;
	
	/*public UsersDAOImpl (SessionFactory sessionFactory)
	
	{
	
		this.sessionFactory=sessionFactory;
		
	}*/

	@Transactional
	public boolean save(Users users) 
	{
	
	try
	{
		sessionFactory.getCurrentSession().save(users);
		
		return true;
	}
	
	catch (Exception e)
	
	{
	
		e.printStackTrace();
		
		return false;
		
	}
	
	}
	@Transactional
	
	public boolean update(Users users) 
	
	
	{
		try
		
		{
		
			sessionFactory.getCurrentSession().update(users);	
		
		return true;
		
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
			return false;	
		
		}
		
	}

	@Transactional
	public Users validate(String id, String password)
	
	{
	
		String hql="from where id='"+id+"'and password='"+password+"'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return(Users)((org.hibernate.Query) query).uniqueResult();
	
	}

	@Transactional
	
	public Users get(int id)
	
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	
	public List<Users> getAllUsers()
	
	{
	
		String hql = "from Users";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
	System.out.println("retriving the userss");
		
		return ((org.hibernate.Query<Users>) query).list();
	
	}

	@Transactional
	public List<Users> list() {
		@SuppressWarnings("deprecation")
		Criteria c= sessionFactory.getCurrentSession().createCriteria(Users.class);
		@SuppressWarnings({ "unchecked", "unused" })
		List<Users> list=c.list();
		return list;
	}

	@Transactional
	public List<Users> getuser(int id) {
		
		String hql = "from Users where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Users>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list;
		}
	}

	@Transactional
	public Users authuser(String username, String password) {
		String hql="from Users where Username= "+"'"+username+"'"+"and password= "+"'"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Users>list=query.list();
		if(list==null)
		{
			return null;
		}
		else{
			return list.get(0);
		}
		
	}

	@Transactional
	public Users logout(int id) 
	{
	
		String hql="from Users where id="+"'"+ id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Users>list=query.list();
		
		if(list==null)
		{
			return null;
			
		}
		else
		{
			return list.get(0);
		}
		
	}

	public Users validate(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	public Users logout(int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	
	
	
	
	
}
