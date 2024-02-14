package it.cefi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Utente {
	
	@Id
	@Column(length = 20,nullable = false)
	private String username;
	
	@Column(length = 30,nullable = false)
	private String nome;
	
	@Column(length = 40,nullable = false)
	private String cognome;
	
	@Column(name = "pwd",length = 30,nullable = false)
	private String password;
	
	@Column(length = 10,nullable = false)
	private String ruolo;
	
	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	

}
