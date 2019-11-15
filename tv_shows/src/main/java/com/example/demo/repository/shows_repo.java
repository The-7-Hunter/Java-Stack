package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.shows;

@Repository
public interface shows_repo extends CrudRepository<shows, Long>{
	List<shows> findAll();
}
