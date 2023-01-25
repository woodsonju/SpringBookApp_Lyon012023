package fr.dawan.gestioncomptebancaire.service;

import org.springframework.data.domain.Page;

import fr.dawan.gestioncomptebancaire.entities.Compte;
import fr.dawan.gestioncomptebancaire.entities.Operation;

public interface IBankService {

	public Compte consulterCompte(String numCompte);
	public void retirer(String numCompte, double montant); 
	public void verser(String numCompte, double montant);
	public void virement(String numCompte1, String numCompte2, double montant);
	public Page<Operation> listOperation(String numCompte, int page, int size);
	
	
}
