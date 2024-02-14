package it.cefi.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;





@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(autentica -> 
		               autentica.requestMatchers("/user/registra","/user/salva")
		                .permitAll().requestMatchers("/css/**").permitAll().requestMatchers("/images/**").permitAll()
		                .requestMatchers("/avvia/gioco").hasAuthority("USER")
		                .requestMatchers("/avvia/ins","/user/list","/avvia/canc").hasAuthority("ADMIN")
		                        .anyRequest().authenticated());

        http.csrf(csrf -> csrf.disable());
        
        http.formLogin(login -> login.loginPage("/login").permitAll());
		
		http.logout(logout -> logout.permitAll());
		
		http.exceptionHandling(e -> e.accessDeniedPage("/403"));
		//quando c è un errore di autenticazione genererà la route data, 
		//che è collegata alla pagina di errore con l'accesso negato
		
		
		return http.build();
		
	}
	
	/*
	  cambia l'impostazione di defaut che usa spring per eseguire hashing delle password 
	  la classe che utilizzerà Spring per la codifica
	 */
	@Bean
	BCryptPasswordEncoder endcode() {
		
		return new BCryptPasswordEncoder();
		
	}
}
