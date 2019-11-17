package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.models.user;
import com.example.demo.repository.user_repo;

@Service
public class user_services {
	private final user_repo user_repos;

	public user_services(user_repo user_repo) {
		this.user_repos = user_repo;
	}

	public List<user> allUsers() {
		return user_repos.findAll();
	}

	public user createUser(user one) {
		return user_repos.save(one);
	}

	public user findUser(Long id) {
		Optional<user> optional_user = user_repos.findById(id);
		if (optional_user.isPresent()) {
			return optional_user.get();
		} else {
			return null;
		}
	}

	// register user and hash their password

	public user registerUser(user user) {

		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

		user.setPassword(hashed);

		return user_repos.save(user);

	}

	// find user by email

	public user findByEmail(String email) {

		return user_repos.findByEmail(email);

	}

	// find user by id

	public user findUserById(Long id) {

		Optional<user> u = user_repos.findById(id);

		if (u.isPresent()) {

			return u.get();

		} else {

			return null;

		}

	}

	// authenticate user

	public boolean authenticateUser(String email, String password) {

		// first find the user by email

		user user = user_repos.findByEmail(email);

		// if we can't find it by email, return false

		if (user == null) {

			return false;

		} else {

			// if the passwords match, return true, else, return false

			if (BCrypt.checkpw(password, user.getPassword())) {

				return true;

			} else {

				return false;

			}

		}

	}

	public boolean duplicateUser(String email) {
		user user = user_repos.findByEmail(email);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
