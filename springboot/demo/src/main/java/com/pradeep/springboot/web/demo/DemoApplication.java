package com.pradeep.springboot.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		BinarySearch binarySearch= new BinarySearch(new QuickSortAlgo());
//		int result=binarySearch.binarySearch(new int[] {1,2,3},3);
//		System.out.println(result);
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
		int result=binarySearch.binarySearch(new int[] {1,2,3},3);
		System.out.println(result);
		
		
		
	}

}
