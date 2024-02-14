package it.cefi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.models.Domande;



@Repository
public interface DomandeRepository extends JpaRepository<Domande, Integer> {

	
}
