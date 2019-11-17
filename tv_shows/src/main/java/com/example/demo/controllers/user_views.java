package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.rattings;
import com.example.demo.models.shows;
import com.example.demo.models.user;
import com.example.demo.services.rattings_services;
import com.example.demo.services.shows_services;
import com.example.demo.services.user_services;
import com.example.demo.validator.user_validator;

@Controller
public class user_views {
	private final shows_services shows_serve;
	private final rattings_services rattings_serve;
	private final user_services user_serve;
	private final user_validator user_valid;

	public user_views(shows_services shows_serve, rattings_services rattings_serve, user_services user_serve,
			user_validator user_valid) {
		this.shows_serve = shows_serve;
		this.rattings_serve = rattings_serve;
		this.user_serve = user_serve;
		this.user_valid = user_valid;
	}

	@PostMapping("/register")

    public String register(@Valid @ModelAttribute("userObj") user user, BindingResult result, Model model, HttpSession session) {

        user_valid.validate(user, result);

        if(result.hasErrors()) {

            return "index.jsp";

        }

        boolean isDuplicate = user_serve.duplicateUser(user.getEmail());

        if(isDuplicate) {

            model.addAttribute("error", "Email already in use! Please try again with a different email address!");

            return "index.jsp";

        }

        user u = user_serve.registerUser(user);

        session.setAttribute("userid", u.getId());

        session.setAttribute("username", u.getUsername());

//        session.setAttribute("numberTasks", u.getTask().size());

        return "redirect:/shows";

    }

	@PostMapping("login")

	public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, @ModelAttribute("userObj") user user) {

		boolean isAuthenticated = user_serve.authenticateUser(email, password);

		if (isAuthenticated) {

			user u = user_serve.findByEmail(email);

			session.setAttribute("userId", u.getId());
	        session.setAttribute("username", u.getUsername());


			return "redirect:/shows";

		}

		else {

			model.addAttribute("error", "Invalid Credentials! Please try again with the correct user information!");

			return "index.jsp";

		}

	}

	@GetMapping("/logout")

	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";

	}

	@RequestMapping("/")
	public String index(@ModelAttribute("userObj") user user) {
		return "index.jsp";
	}

	@RequestMapping("/shows")
	public String shows(Model model, HttpSession session) {
		List<shows> all = shows_serve.allshows();
		model.addAttribute("shows", all);
		model.addAttribute("username", session.getAttribute("username"));
		return "shows.jsp";
	}

	@RequestMapping("/shows/{id}")
	public String displayShow(@PathVariable("id") Long id, Model model, @ModelAttribute("rate") rattings rate) {
		shows show = shows_serve.findShow(id);
		List<rattings> all = rattings_serve.getShowsRattings(id);
		double avg = 0;
		double size = all.size();
		for (int i = 0; i < size; i++) {
			avg = avg + all.get(i).getRate_value();
		}
		avg = avg / size;
		model.addAttribute("size", avg);
		model.addAttribute("rattings", all);
		model.addAttribute("show", show);
		return "displayShow.jsp";
	}

	@RequestMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id") Long id, Model model) {
		shows show = shows_serve.findShow(id);
		model.addAttribute("show", show);
		return "editShow.jsp";
	}

	@RequestMapping(value = "/editshow", method = RequestMethod.POST)
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

	@RequestMapping(value = "/shows/{id}/delete", method = RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
		shows_serve.deleteShow(id);
		return "redirect:/shows";
	}

	@RequestMapping(value = "/newrate", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("rate") rattings rate, BindingResult result) {
		if (result.hasErrors()) {
			return "displayShow.jsp";
		} else {
			rattings_serve.createRate(rate);
			return "redirect:/shows";
		}
	}
}