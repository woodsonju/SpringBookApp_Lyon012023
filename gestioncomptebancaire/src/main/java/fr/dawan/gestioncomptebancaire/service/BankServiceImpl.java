package fr.dawan.gestioncomptebancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.gestioncomptebancaire.dao.CompteRepository;
import fr.dawan.gestioncomptebancaire.dao.OperationRepository;
import fr.dawan.gestioncomptebancaire.entities.Compte;
import fr.dawan.gestioncomptebancaire.entities.Operation;

@Service
@Transactional
public class BankServiceImpl implements IBankService {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	
	@Override
	public Compte consulterCompte(String numCompte) {
		
		return null;
	}

	@Override
	public void retirer(String numCompte, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verser(String numCompte, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void virement(String numCompte1, String numCompte2, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Operation> listOperation(String numCompte, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
