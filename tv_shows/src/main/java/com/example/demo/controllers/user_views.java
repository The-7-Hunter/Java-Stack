package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.shows;
import com.example.demo.services.shows_services;

@Controller
public class user_views {
	private final shows_services shows_serve;

	public user_views(shows_services shows_serve) {
		this.shows_serve = shows_serve;
	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/shows")
	public String shows(Model model) {
		List<shows> all = shows_serve.allshows();
		model.addAttribute("shows", all);
		return "shows.jsp";
	}

	@RequestMapping("/shows/{id}")
	public String displayShow(@PathVariable("id") Long id, Model model) {
		shows show = shows_serve.findShow(id);
		model.addAttribute("show", show);
		return "displayShow.jsp";
	}

	@RequestMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id") Long id, Model model) {
		shows show = shows_serve.findShow(id);
		model.addAttribute("show", show);
		return "editShow.jsp";
	}

	@RequestMapping(value="/editshow", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("show") shows show, BindingResult result) {
		if (result.hasErrors()) {
			return "editShow.jsp";
		} else {
			shows_serve.updateShow(show);
			return "redirect:/shows";
		}
	}

	@RequestMapping("/shows/new")
	public String newShow(@ModelAttribute("show") shows show) {
		return "newShow.jsp";
	}

	@RequestMapping(value = "/newshow", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("show") shows show, BindingResult result) {
		if (result.hasErrors()) {
			return "newShow.jsp";
		} else {
			shows_serve.createShow(show);
			return "redirect:/shows";
		}
	}
	
    @RequestMapping(value="/shows/{id}/delete", method=RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id) {
        shows_serve.deleteShow(id);
        return "redirect:/shows";
    }
}
