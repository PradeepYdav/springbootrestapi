package com.pradeep.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorld {
	
	
	
	@Autowired
	private MessageSource getmessage;
	//type
	//uri
	//method
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-get")
	public String helloWorldget() {
		return "Hello World";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format(" Hello Wordld %s", name));
	}
	
	@GetMapping(path="/helloWorldInternatioalization")
	public String helloWorldInternatioalization(@RequestHeader(name="Accept-language",required=false)Locale locale) {
		return getmessage.getMessage("good.morning.message", null, locale);
	}

}
