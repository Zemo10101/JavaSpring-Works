package it.cefi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.models.Domande;
import it.cefi.models.Risposte;
import it.cefi.service.QuizService;

@RestController
@RequestMapping("/visualizza")
public class VisualizzaController {
	
	@Autowired
	QuizService quizService;
	
	
	int indiceD=0;
	int indiceR=0;

	@PostMapping("/listaDomande")
	public ResponseEntity<Domande> avviaQuiz() {
		
		
		 List<Domande> domande = quizService.getAllDomande();
		 
		 if(domande.size()==indiceD) {
			 indiceD=0;
		 }
			 
		//String domanda=domande.get(indice).getTesto();
		 Domande d=domande.get(indiceD);
		
	   indiceD++;
		return ResponseEntity.ok(d);
	}
	
	@PostMapping("/listaRisposte")
	public List <Risposte> giocaQuiz() {
		
		 List<Domande> domande = quizService.getAllDomande();
		 
		 if(domande.size()==indiceR) {
			 indiceR=0;
		 }
		 
		 Domande d=domande.get(indiceR);
		 
		 
		
		List <Risposte> risposte = quizService.getAllRisposteOfDomanda((int) d.getIdDomande());
	
		indiceR++;
		return risposte;
		
		
	}
	
	@GetMapping("/durata")
	public int durataGioco() {
		
		List <Domande> x = quizService.getAllDomande();
	    
		return x.size();
		
	}
	
	

}
