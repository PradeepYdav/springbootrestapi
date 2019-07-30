package com.pradeep.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
	
	public int id;
	public String name;
	public Date age;
	
	
	protected void name() {
		
	} User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int id, String name, Date age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, age=%s]", id, name, age);
	}
	
	

}
