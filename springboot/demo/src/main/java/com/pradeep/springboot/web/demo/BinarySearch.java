package com.pradeep.springboot.web.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BinarySearch {
	
	
	@Autowired
	private SortAlgo sortAlgo;
	
	
	
	public BinarySearch(SortAlgo sortAlgo) {
		super();
		this.sortAlgo = sortAlgo;
	}



	public int binarySearch(int [] numbers,int number) {
		
		 int [] soretednumbers=sortAlgo.sort(numbers);
		 
		 System.out.println(sortAlgo);
		
		return 3;
	}

}
