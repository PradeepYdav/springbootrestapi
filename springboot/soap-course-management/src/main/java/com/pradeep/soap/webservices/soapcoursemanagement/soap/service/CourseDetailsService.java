package com.pradeep.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pradeep.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {
	
	private static List<Course> courses= new ArrayList<Course>();
	
	static {
		Course course1= new Course(1, "spring", "spring framework");
		courses.add(course1);
		
		Course course2= new Course(2, "spring mvc", "spring  mvc framework");
		courses.add(course2);
		
		Course course3= new Course(3, "spring boot", "spring boot framework");
		courses.add(course3);
	}
	//get by id 
	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;

	}
	
	// get all
		
		public List<Course> findAll(){
			return courses;
		}
	
	// delete  by id
		public int deleteById(int id) {
			Iterator<Course>iterator=  courses.iterator();
			while (iterator.hasNext()) {
				Course course =  iterator.next();
				if(course.getId()==id) {
					iterator.remove();
					return 1;
				}
				
			} 
			return 0;
			}
		
	
	
	

}
