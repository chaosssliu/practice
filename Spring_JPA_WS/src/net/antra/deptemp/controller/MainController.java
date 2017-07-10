package net.antra.deptemp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.antra.deptemp.service.DepartmentService;
import net.antra.deptemp.service.WeatherDelegateService;
@Controller
public class MainController {
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	WeatherDelegateService ws;
	
	@RequestMapping("/main")
	public String showMain(ModelMap model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.loadDeptDetails());
		model.addAttribute("weather", ws.getWeatherByZip("20165"));

		return "welcome";
	}
}
