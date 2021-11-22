package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.simplilearn.workshop.model.Admins;

public interface AdminService {
	
	
	public List<Admins> getAdmins();
	public Admins saveAdmin(Admins theAdmin);
	public Admins getAdmin(Integer theId);
	public void deleteAdmin(Integer theId);
	public Admins login(String username,String password);

}
