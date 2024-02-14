package it.cefi.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "risposte")
public class Risposte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRisposte;
	
	@Column(length = 50, nullable = false)
	private String testo;
	
	@Column()
	private boolean val;
	
	@ManyToOne
	@JoinColumn(name="idDomande")
	private Domande domanda;
	

	public Risposte(long idRisposte, String testo, boolean val, Domande domanda) {
		super();
		this.idRisposte = idRisposte;
		this.testo = testo;
		this.val = val;
		this.domanda = domanda;
	}
	
	public Risposte() {
		
	}
	
	public Domande getDomanda() {
		return domanda;
	}


	public void setDomanda(Domande domanda) {
		this.domanda = domanda;
	}


	public long getIdRisposte() {
		return idRisposte;
	}

	public void setIdRisposte(long idRisposte) {
		this.idRisposte = idRisposte;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public boolean isVal() {
		return val;
	}

	public void setVal(boolean val) {
		this.val = val;
	}
	
	
}

