package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Astronaut;
import boots.service.AstronautService;

@Controller
public class AstronautController {

	@Autowired
	private AstronautService astronautService;
	
	@GetMapping("/all-astronauts")
	public String allAstronauts(HttpServletRequest request){
		request.setAttribute("astronauts", astronautService.findAll());
		request.setAttribute("mode", "MODE_ASTRONAUTS");
		return "astronaut";
	}
	
	@GetMapping("/new-astronaut")
	public String newAstronaut(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "astronaut";
	}
	
	@GetMapping("/update-astronaut")
	public String updateAstronaut(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("astronaut", astronautService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "astronaut";
	}
	
	@GetMapping("/delete-astronaut")
	public String deleteAstronaut(@RequestParam int id,HttpServletRequest request){
		astronautService.delete(id);
		request.setAttribute("astronauts", astronautService.findAll());
		request.setAttribute("mode", "MODE_ASTRONAUTS");
		return "astronaut";
	}
	
	@PostMapping("/save-astronaut")
	public String saveStudent(@ModelAttribute Astronaut astronaut,
			BindingResult bindingResult,HttpServletRequest request){
		astronautService.save(astronaut);
		request.setAttribute("astronauts", astronautService.findAll());
		request.setAttribute("mode", "MODE_ASTRONAUTS");
		return "astronaut";
		
	}
	
}
