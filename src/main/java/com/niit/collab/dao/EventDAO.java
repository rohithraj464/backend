package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Event;
import com.niit.collab.model.Forum;

public interface EventDAO {

	public boolean saveOrUpdate(Event event);
	public boolean delete(Event event);
	
	public List<Event> list();
	public Event getevent(int id);

}
