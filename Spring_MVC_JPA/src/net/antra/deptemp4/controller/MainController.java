package net.antra.deptemp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String showMain(ModelMap model) {
		model.addAttribute("user", "Antra!");
		return "welcome";
	}
}