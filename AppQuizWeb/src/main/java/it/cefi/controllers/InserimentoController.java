package it.cefi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.cefi.models.Domande;
import it.cefi.models.Quiz;
import it.cefi.models.Risposte;
import it.cefi.service.QuizService;

@RestController
@RequestMapping("/invio")
public class InserimentoController {

	@Autowired
	QuizService quizService;
		
		@PostMapping
	    public void inserisci(@RequestBody Quiz quiz) {
			
			Domande domanda= new Domande(0,quiz.getD1());
			
			quizService.saveDomanda(domanda);
			
			quizService.saveRisposta(new Risposte(0,quiz.getR1(),quiz.isVal1(),domanda));
			quizService.saveRisposta(new Risposte(0,quiz.getR2(),quiz.isVal2(),domanda));
			quizService.saveRisposta(new Risposte(0,quiz.getR3(),quiz.isVal3(),domanda));
			quizService.saveRisposta(new Risposte(0,quiz.getR4(),quiz.isVal4(),domanda));
			
			System.out.println(quiz);
			
		}
	}
	
	

