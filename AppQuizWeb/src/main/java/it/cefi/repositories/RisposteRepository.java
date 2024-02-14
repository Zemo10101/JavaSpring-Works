package it.cefi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.models.Risposte;


@Repository
public interface RisposteRepository extends JpaRepository<Risposte, Integer> {

	
}
