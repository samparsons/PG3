package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Admins;

public interface AdminRepository extends JpaRepository<Admins, Integer>{
	
	Admins findFirstDistinctByUsernameAndPassword(String username,String Password);
}
