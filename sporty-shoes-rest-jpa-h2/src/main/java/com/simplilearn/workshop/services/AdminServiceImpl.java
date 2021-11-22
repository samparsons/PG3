package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Admins;
import com.simplilearn.workshop.repository.AdminRepository;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admins> getAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admins saveAdmin(Admins theAdmin) {
		// TODO Auto-generated method stub
		return adminRepository.save(theAdmin);
	}

	@Override
	public Admins getAdmin(Integer theId) {
		// TODO Auto-generated method stub
		return adminRepository.getById(theId);
	}

	@Override
	public void deleteAdmin(Integer theId) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(theId);
	}
	
	@Override
	public Admins login(String username,String password) {
		// TODO Auto-generated method stub
		return adminRepository.findFirstDistinctByUsernameAndPassword(username, password);
	}
	
	

}
