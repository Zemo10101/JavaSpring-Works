package it.cefi.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.models.Domande;
import it.cefi.service.QuizService;

@RestController
@RequestMapping("/cancella")
public class CancellaController {

	
	@Autowired
	QuizService quizService;
		
	@PostMapping("/delete")
    public void cancella(@RequestBody String id) {
		
		 String cleanId = id.replaceAll("\"", "");
		quizService.deleteQuiz(cleanId);
		
	}
	
	
	
	@GetMapping("/load")
	public List<Domande> carica() {
			
			 List<Domande> domande= quizService.getAllDomande();		 
			 
			return domande;
			
	}
}
