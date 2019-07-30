package com.pradeep.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	
	// retervive ALL user
	@GetMapping(path="/users")
	public List<User> reteriveAllUsers() {
		return userDaoService.findAll(); 
	}
	
	//get user using id
	@GetMapping(path="/users/{id}")
	public User getuser(@ PathVariable int id) {
		User user=userDaoService.findone(id);
		if (user==null) {
			throw new UserNotFoundException("id-"+id);
			
		}
		return  user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> SaveUser(@RequestBody User user) {
		User createdUser=userDaoService.saveuser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return  ResponseEntity.created(location).build(); 
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteuser(@PathVariable int id) {
		User user=userDaoService.deleteuser(id);
		if (user==null) {
			throw new UserNotFoundException("id -"+id);
		}
	}
}
