package fr.dawan.gestioncomptebancaire.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.gestioncomptebancaire.service.IBankService;

//Un controller c'est une classe qui contient l'annotation @Controller
@Controller
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@GetMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	

}
