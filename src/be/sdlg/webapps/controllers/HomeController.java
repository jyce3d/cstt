package be.sdlg.webapps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value={"/", "home.htm"}, method=RequestMethod.GET)
	public String home(Model model) {
	
		// To do: fille the stub
		return "home";
	}
}
