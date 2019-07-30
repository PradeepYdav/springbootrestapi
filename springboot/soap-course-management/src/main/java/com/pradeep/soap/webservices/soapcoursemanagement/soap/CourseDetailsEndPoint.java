package com.pradeep.soap.webservices.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pradeep.course_details.CourceDetails;
import com.pradeep.course_details.GetCourceDeatilsRequest;
import com.pradeep.course_details.GetCourceDeatilsResponse;
import com.pradeep.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.pradeep.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndPoint {
	
	//method
// request 
	// resp
	
	@Autowired
	CourseDetailsService services;
	
	@PayloadRoot(namespace="http://www.pradeep.com/course-details",localPart="GetCourceDeatilsRequest")
	@ResponsePayload
	public GetCourceDeatilsResponse processCourceDetailsRequest(@RequestPayload GetCourceDeatilsRequest request) {
		
		GetCourceDeatilsResponse resp= new GetCourceDeatilsResponse();
		 Course course=services.findById(request.getId());
		 
		CourceDetails courceDetails= new CourceDetails();
		courceDetails.setId(course.getId());
		courceDetails.setName(course.getName());
		courceDetails.setDescription(course.getDescription());
		
		resp.setCourceDetails(courceDetails);
		
		return  resp;
		
	}

}
