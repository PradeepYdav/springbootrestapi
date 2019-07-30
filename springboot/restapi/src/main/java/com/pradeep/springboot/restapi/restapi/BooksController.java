package com.pradeep.springboot.restapi.restapi;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Books> getbooks(){
		return Arrays.asList(new Books(1l, "rest Api", "Pradeep yadav"));
	}
	
	@GetMapping("/books1")
	public String getbooks1(){
		 return new Books(2l, "rest Api 1", "Pradeep yadav 2").toString();
	}

}
