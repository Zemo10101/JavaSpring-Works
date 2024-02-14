package it.cefi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cefi.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, String> {

	 Utente findByUsername(String username);
}
