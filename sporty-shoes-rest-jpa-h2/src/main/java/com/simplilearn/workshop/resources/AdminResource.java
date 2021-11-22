package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.exception.AdminNotFoundException;
import com.simplilearn.workshop.model.Admins;
import com.simplilearn.workshop.services.AdminService;


@RestController
public class AdminResource {
	@Autowired
	private AdminService adminService;
	
	@GetMapping(path="/admins")
	public List<Admins> retrieveAdmins() {
		return adminService.getAdmins();
	}
	
	@GetMapping(path="/admins/{theId}")
	public Admins retrieveAdmin(@PathVariable Integer theId) {
		Admins theAdmin = adminService.getAdmin(theId);
		return theAdmin;
	}
	
	@GetMapping(path="/admins/login/{username}/{password}")
	public  Admins login(@PathVariable String username,@PathVariable String password) {
		if(username==null||password==null) {
			throw new AdminNotFoundException("username or password was null <br>username:" +username+"<br>password: "+password);
		}
		Admins admins = adminService.login(username, password);
		if (admins == null) {
			throw new AdminNotFoundException("username -" +username);
		}
		return admins;
	}
	
	//POST URI : localhost:8080/admins
		//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
		//Response : status code : 201 , URI --- > new resource in a response header
		@PostMapping(path = "/admins")
		public ResponseEntity<Admins> createAdmin(@Valid @RequestBody Admins theAdmin) {
			Admins savedAdmin = adminService.saveAdmin(theAdmin);
			
			// location : localhost:8080/admins/4
			URI location = ServletUriComponentsBuilder
					 .fromCurrentRequest()
					 .path("/{theId}")
					 .buildAndExpand(savedAdmin.getId())
					 .toUri();
			return ResponseEntity.created(location).build();
		}
		
		// assigment  : update the admin @PutMapping
		//response : 204
		@PutMapping(path="/admins/{theId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void updateAdmin(@PathVariable Integer theId,@RequestBody Admins theAdmin) {
			Admins savedAdmin = adminService.getAdmin(theId);
			savedAdmin.setId(theId);
			savedAdmin.setName(theAdmin.getName());
			savedAdmin.setPhone(theAdmin.getPhone());
			savedAdmin.setEmail(theAdmin.getEmail());
			savedAdmin.setUsername(theAdmin.getUsername());
			savedAdmin.setPassword(theAdmin.getPassword());
		}
		
		@DeleteMapping(path="/admins/{theId}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteAdmin(@PathVariable Integer theId) {
			Admins theAdmin = adminService.getAdmin(theId);
			if ( theAdmin == null) {
				throw new AdminNotFoundException("id -" +theId);
			}
			
			adminService.deleteAdmin(theId);
		}
	
	
}
