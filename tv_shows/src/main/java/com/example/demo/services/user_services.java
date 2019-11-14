package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.user;
import com.example.demo.repository.user_repo;

@Service
public class user_services {
	private final user_repo user_repos;
	
	public user_services(user_repo user_repo) {
		this.user_repos = user_repo;
	}
	
	public List<user> allUsers(){
		return user_repos.findAll();
	}
	
	public user createUser(user one) {
		return user_repos.save(one);
	}
	
	public user findUser(Long id) {
		Optional<user> optional_user = user_repos.findById(id);
		if(optional_user.isPresent()) {
			return optional_user.get();
		}
		else {
			return null;
		}
	}
}
