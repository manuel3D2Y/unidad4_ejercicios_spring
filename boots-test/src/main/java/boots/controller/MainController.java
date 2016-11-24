package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Client;
import boots.model.Astronaut;
import boots.model.Task;
import boots.service.ClientService;
import boots.service.AstronautService;
import boots.service.TaskService;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	@GetMapping("/task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_TASK");
		return "task";
	}
	
	@GetMapping("/astronaut")
	public String astronaut(HttpServletRequest request){
		request.setAttribute("mode", "MODE_ASTRONAUT");
		return "astronaut";
	}
	
	@GetMapping("/client")
	public String client(HttpServletRequest request){
		request.setAttribute("mode", "MODE_CLIENT");
		return "client";
	}
	
	
}
