package com.pradeep.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	public static List<User> users= new ArrayList<User>();
	
	public static int count=3;
	
	static {
		users.add(new User(1, "Pradeep", new Date()));
		users.add(new User(2, "Sandeep", new Date()));
		users.add(new User(3, "Raj", new Date()));
	}
	
	//get all list

	public List<User> findAll(){
		return users;
	}
	
	// save user
	
	public User saveuser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	// get one
	public User findone(int id) {
		for (User user:users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public User deleteuser(int id) {
		// TODO Auto-generated method stub
		
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if (user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}

}
