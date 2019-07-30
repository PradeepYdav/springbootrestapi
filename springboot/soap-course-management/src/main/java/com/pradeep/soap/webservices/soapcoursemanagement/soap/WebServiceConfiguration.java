package com.pradeep.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//enable web services 
@EnableWs
//Spring configurauion
@Configuration
public class WebServiceConfiguration {
	
	//message Servelet diapacher 
	
	@Bean
	public ServletRegistrationBean  messageDishpatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDishpatcherServlet= new MessageDispatcherServlet();
		messageDishpatcherServlet.setApplicationContext(context);
		messageDishpatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDishpatcherServlet,"/ws/*");
	}
	
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema CoursesSchema) {
		DefaultWsdl11Definition definition= new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://www.pradeep.com/course-details");
		definition.setLocationUri("/ws");
		definition.setSchema(CoursesSchema);
				
		return definition;
	}
	
	@Bean
	public XsdSchema CoursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

}
