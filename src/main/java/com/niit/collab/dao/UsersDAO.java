package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Users;

public interface UsersDAO
{

	public boolean save(Users users);
	
	public boolean update(Users users);
	
	public Users validate(int id,String password);
	
	
	public List<Users> list();

	public List<Users> getuser(String id);
	public Users logout(int id);
	public Users authuser(String username,String password);
	
	
}