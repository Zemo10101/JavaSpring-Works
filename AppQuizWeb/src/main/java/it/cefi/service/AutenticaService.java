package it.cefi.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.cefi.models.Utente;
import it.cefi.repositories.UtenteRepository;

@Service
public class AutenticaService implements UserDetailsService{
	
    @Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Utente ut= utenteRepository.findByUsername(username);
		 
		 if(ut==null) {
			 throw new UsernameNotFoundException("Username errato");
		 }
		 // la password viene per default codificata e con BCryptPasswordEncoder() 
		 //abbiamo la possibilità di decodificare la password tramite il metodo encode()
		 String pwd= new BCryptPasswordEncoder().encode(ut.getPassword());
		 String roulo =ut.getRuolo();
		 User user =new User(username,pwd,Collections.singleton(new SimpleGrantedAuthority(roulo)));
		 
		return user;
	}

	
	
	
	
}
