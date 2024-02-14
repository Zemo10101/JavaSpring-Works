package it.cefi.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Domande;
import it.cefi.models.Risposte;
import it.cefi.repositories.DomandeRepository;
import it.cefi.repositories.RisposteRepository;


@Service
public class QuizService  {

	//creo l'oggetto dell'interfaccia
	
	@Autowired
	private DomandeRepository domandeRepository;
	
	@Autowired
	private RisposteRepository risposteRepository;
	
	int min=0;
	int max=4;
	
	
	public void saveDomanda (Domande x)
	{
		domandeRepository.save(x); 
	}
	
	public void saveRisposta (Risposte x)
	{
		risposteRepository.save(x); 
	}
	
	public void deleteQuiz (String id) {
		
		
		List<Risposte> risp= risposteRepository.findAll();
		
		for(Risposte x:risp) {
			Domande d=x.getDomanda();
			    if(d.getIdDomande()==Integer.parseInt(id)){
				 risposteRepository.delete(x);
			    }
			}
		
		domandeRepository.deleteById(Integer.parseInt(id));
	}
	
	
	public List<Domande> getAllDomande ()
	{
		
		return domandeRepository.findAll();
	}
	
	public List<Risposte> getAllRisposte ()
	{
		
		return risposteRepository.findAll();
	}
	
	
	public List<Risposte> getAllRisposteOfDomanda (int n)
	{
		
		
		List<Risposte> risp= risposteRepository.findAll();
	/*	
		if(max>risp.size()) {
			min=0;
		    max=4;
		}
		*/
		//List <Risposte> rispFiltrata=risp.subList(min, max);
		
		List <Risposte> risposteFiltrate = new ArrayList<>();
		
		for(Risposte x:risp) {
			Domande d=x.getDomanda();
			
			    if(d.getIdDomande()==n){
				risposteFiltrate.add(x);
			    }
		}
		
		
	//	min+=4;
	//	max+=4;
		return risposteFiltrate;
	}
	

	
	

}
