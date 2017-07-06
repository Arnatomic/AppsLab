package app.appslab.example;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Exemple {

	@Id
	@Column(name = "example", length = 9)
	private String nif;
	@Required
	@Column(length = 40)
	private String nom;
	private Date dNaix;
	
	public Exemple() {}
	
	
	public Exemple(String nif, String nom, Date dNaix) {
		this.nif = nif;
		this.nom = nom;
		this.dNaix  = dNaix;		
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Date getdNaix() {
		return dNaix;
	}


	public void setdNaix(Date dNaix) {
		this.dNaix = dNaix;
	}
	
	
	
}
