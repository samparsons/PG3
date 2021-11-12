package com.simplilearn.workshop.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.workshop.model.Admin;

@FeignClient(name = "sporty-shoes-rest-jpa-h2",url="localhost:8080")
public interface AdminServiceRestProxy {
	@GetMapping(path="/admins")
	public List<Admin> retrieveAdmins();
	@GetMapping(path = "/admins/{theId}")
	public Admin retrieveAdmin(@PathVariable Integer theId);
	@PostMapping(path = "/admins")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin theAdmin);
	@PutMapping("/admins/{theId}")
	public void updateAdmin(@PathVariable Integer theId,@RequestBody Admin theAdmin);
	@DeleteMapping("/admins/{theId}")
	public void deleteAdmin(@PathVariable Integer theId) ;
}
