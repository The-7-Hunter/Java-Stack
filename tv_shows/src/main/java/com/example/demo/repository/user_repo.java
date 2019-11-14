package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.user;

@Repository
public interface user_repo extends CrudRepository<user, Long>{
	
		List<user> findAll();
}

