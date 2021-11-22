package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Admins;

public interface AdminRepository extends JpaRepository<Admins, Integer>{
	
	
	//for purchases - https://stackoverflow.com/questions/13154818/how-to-define-a-jpa-repository-query-with-a-join
	//https://thorben-janssen.com/how-to-join-unrelated-entities/
	//https://www.baeldung.com/jpa-query-unrelated-entities
	//@Query("SELECT p.purchaseId,p.purchaseDate,pr.productName,sum(pr.price),c.categoryName FROM Categories c WHERE c.productId = ?1")
	//List<Object[]> findAllByProduct(Integer theId);

}
