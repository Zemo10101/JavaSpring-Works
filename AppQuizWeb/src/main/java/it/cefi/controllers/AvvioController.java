package it.cefi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/avvia")
public class AvvioController {

	
	@GetMapping("/gioco")
	public String load() {
		
		return "giocaQuiz";
		
	}
	
	@GetMapping("/ins")
	public String insert()
	{
		return "inserisciQuiz";
	}
	
	@GetMapping("/canc")
	public String delete()
	{
		return "delete";
	
	}
}