package it.cefi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.cefi.models.Utente;
import it.cefi.service.UtenteService;

@Controller
@RequestMapping("/user")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/registra")
	public String registra()
	{
		return "user_form";
	}
	
	@PostMapping("/salva")
	public String save(@ModelAttribute Utente utente) {
		
		utente.setRuolo("USER");
		utenteService.save(utente);
		return "user_form";
		
	}
	
	@GetMapping("/list")
	public ModelAndView lista()
	{
		List<Utente> users=utenteService.findAllUser();
		return new ModelAndView("listaUtenti","utenti",users);
	}
}
