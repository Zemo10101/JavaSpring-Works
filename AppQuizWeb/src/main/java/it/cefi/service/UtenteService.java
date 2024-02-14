package it.cefi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Utente;
import it.cefi.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;
	
	public void save(Utente ut) {
		
		utenteRepository.save(ut);
	}
	
	public List<Utente> findAllUser() {
		
		return utenteRepository.findAll();
	}
}
