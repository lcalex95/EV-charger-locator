package ee4216.group10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *  Main Controller that maps Thymeleaf templates to URLs
 */

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/streetview")
	public String streetView(@RequestParam("lat") float lat,@RequestParam("lang") float lang, Model model){
		model.addAttribute("lat",lat);
		model.addAttribute("lng",lang);
		return "streetview";
	}
	@RequestMapping("/routing")
	public String routing(@RequestParam("lat") float lat,@RequestParam("lang") float lang, Model model){
		model.addAttribute("lat",lat);
		model.addAttribute("lng",lang);
		return "routing";
	}
	
	
}
