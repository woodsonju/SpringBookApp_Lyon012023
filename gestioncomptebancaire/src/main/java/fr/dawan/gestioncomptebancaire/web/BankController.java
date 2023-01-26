package fr.dawan.gestioncomptebancaire.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.gestioncomptebancaire.entities.Compte;
import fr.dawan.gestioncomptebancaire.service.IBankService;
import fr.dawan.gestioncomptebancaire.service.exception_.CompteIntrouvableException;
import fr.dawan.gestioncomptebancaire.service.exception_.SoldeInsuffisantException;
import fr.dawan.gestioncomptebancaire.service.exception_.VirementMemeCompteException;

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

	@GetMapping("/consultercompte")
	public String consulterCompte(Model model, String numCompte) {
		Compte cb;
		try {
			cb = bankService.consulterCompte(numCompte);
			model.addAttribute("compte", cb);

		} catch (CompteIntrouvableException e) {

			e.printStackTrace();
			model.addAttribute("compteIntrouvableException", e.getCompteIntrouvable());
		}

		return "comptes";
	}


	@PostMapping("/saveOperation")
	public String saveOperation(Model model, String typeOperation, String numCompte, double montant, 
			String numCompte2) {

		try {
			if(typeOperation.equals("versement")) {
				bankService.verser(numCompte2, montant);
			} else if(typeOperation.equals("retrait")){
				bankService.retirer(numCompte2, montant);
			} else if(typeOperation.equals("virement")) {
				bankService.virement(numCompte, numCompte2, montant);
			}
		} catch (CompteIntrouvableException e) {
			
			e.printStackTrace();
		} catch (SoldeInsuffisantException e) {
	
			e.printStackTrace();
		} catch (VirementMemeCompteException e) {
		
			e.printStackTrace();
		}
		
		return null;

	}

}
