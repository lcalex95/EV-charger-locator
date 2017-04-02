package ee4216.group10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  Main Controller that maps Thymeleaf templates to URLs
 */

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
