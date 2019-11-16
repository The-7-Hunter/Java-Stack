package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.rattings;
import com.example.demo.repository.rattings_repo;

@Service
public class rattings_services {
	private final rattings_repo rattings_repo;
	
	public rattings_services(rattings_repo rattings_repo) {
		this.rattings_repo = rattings_repo;
	}
	
	public List<rattings> allrattings(){
		return rattings_repo.findAll();
	}
	
	public List<rattings> getShowsRattings(long id){
		return rattings_repo.getRatesWhereId(id);
	}
	
	public rattings createRate(rattings one) {
		return rattings_repo.save(one);
	}
}
