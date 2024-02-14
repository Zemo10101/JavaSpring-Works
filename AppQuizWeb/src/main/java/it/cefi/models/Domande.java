package it.cefi.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "domande")
public class Domande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDomande;
	
	@Column(length = 50, nullable = false)
	private String testo;
	
	@OneToMany(mappedBy="domanda")
	private List<Risposte> idRisposte;
	

	public Domande(long idDomande, String testo) {
		super();
		this.idDomande = idDomande;
		this.testo = testo;
	}
	
	public Domande() {
		
	}

	public long getIdDomande() {
		return idDomande;
	}

	public void setIdDomande(long idDomande) {
		this.idDomande = idDomande;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
}
