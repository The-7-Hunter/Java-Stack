package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.shows;
import com.example.demo.repository.shows_repo;

@Service
public class shows_services {
	private final shows_repo shows_repo;
	
	public shows_services(shows_repo shows_repo) {
		this.shows_repo = shows_repo;
	}
	
	public List<shows> allshows(){
		return shows_repo.findAll();
	}
	
	public shows createShow(shows one) {
		return shows_repo.save(one);
	}
	
	public shows findShow(Long id) {
		Optional<shows> optional_show = shows_repo.findById(id);
		if(optional_show.isPresent()) {
			return optional_show.get();
		}
		else {
			return null;
		}
	}
}
