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

	public List<shows> allshows() {
		return shows_repo.findAll();
	}

	public shows createShow(shows one) {
		return shows_repo.save(one);
	}

	public shows findShow(Long id) {
		Optional<shows> optional_show = shows_repo.findById(id);
		if (optional_show.isPresent()) {
			return optional_show.get();
		} else {
			return null;
		}
	}

	public shows updateShow(shows show) {
		return shows_repo.save(show);
	}

	public shows updateShow(long id, String name, String network, Integer average_rating) {
		Optional<shows> showToEdit = shows_repo.findById(id);
		if (showToEdit != null) {
			showToEdit.get().setName(name);
			showToEdit.get().setNetwork(network);

			return showToEdit.get();
		}
		return null;
	}
	
	public void deleteShow(Long id) {
		shows_repo.deleteById(id);
	}
}
