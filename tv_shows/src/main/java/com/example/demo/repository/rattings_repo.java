package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.rattings;

public interface rattings_repo extends CrudRepository<rattings, Long>{
	List<rattings> findAll();
	
	@Query("SELECT R FROM rattings R WHERE show_id = ?1")
	List<rattings> getRatesWhereId(Long id);
}
