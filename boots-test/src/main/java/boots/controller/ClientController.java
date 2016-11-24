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
import boots.service.ClientService;

@Controller
public class ClientController {

	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/all-clients")
	public String allClients(HttpServletRequest request){
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
	}
	
	@GetMapping("/new-client")
	public String newClient(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "client";
	}
	
	@GetMapping("/update-client")
	public String updateClient(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("client", clientService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "client";
	}
	
	@GetMapping("/delete-client")
	public String deleteClient(@RequestParam int id,HttpServletRequest request){
		clientService.delete(id);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
	}
	
	@PostMapping("/save-client")
	public String saveClient(@ModelAttribute Client client,
			BindingResult bindingResult,HttpServletRequest request){
		clientService.save(client);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
		
	}
}
