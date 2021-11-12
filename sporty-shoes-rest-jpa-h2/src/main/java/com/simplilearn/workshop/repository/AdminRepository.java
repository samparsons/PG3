package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Admins;

public interface AdminRepository extends JpaRepository<Admins, Integer>{
	
	
}
