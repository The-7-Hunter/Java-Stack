package com.example.demo;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
//@RestController
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	
//	@RequestMapping("/")
//	public String index(@RequestParam(value = "first", required = false, defaultValue = "Human") String searchQuery, @RequestParam(value = "last", required = false, defaultValue = "Human") String searchQuery1) {
//		return "Name: " + searchQuery + searchQuery1;
//	}
//	
//    @RequestMapping("/m/{track}/{module}/{lesson}")
//    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
//    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
//    }

	@RequestMapping("/testing_render")
	public String HomePage(Model model) {
		model.addAttribute("Name", "Abdullelah");
		return "index.jsp";
	}

//	@RequestMapping("/")
//	public String Home(Model model) {
//		model.addAttribute("Name", "Nawaf");
//		return "index.html";
//	}
//	@RequestMapping("/date")
//	public String date(Model model) {
//		model.addAttribute("date", new java.util.Date());
//		return "date.jsp";
//	}
//
//	@RequestMapping("/time")
//	public String time(Model model) {
//		model.addAttribute("time", new java.util.Date());
//		return "time.jsp";
//	}
//
//	@RequestMapping("/session")
//	public String session(HttpSession session) {
//		Integer counter = (Integer) session.getAttribute("counter");
//		if (counter == null) {
//			counter = 0;
//			session.setAttribute("counter", counter);
//		}
//		session.setAttribute("counter", counter + 2);
//		session.getAttribute("counter");
//		return "session.jsp";
//	}

	@RequestMapping("/")
	public String form() {
		return "form.jsp";
	}
	
	String username;
	String pass;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if(name.isEmpty() || password.isEmpty()) {
			return "redirect:/Error";
		}
		username = name;
		pass = password;
		return "redirect:/dashboard";
	}

	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session) {
		session.setAttribute("name", username);
		session.setAttribute("password", pass);
		
		session.getAttribute("name");
		session.getAttribute("password");
		return "dashboard.jsp";
	}
	
	@RequestMapping("/Error")
	public String Error(RedirectAttributes red) {
		red.addFlashAttribute("error", "Fields cannot be empty!");
		return "redirect:/";
	}
}
