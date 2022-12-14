package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bibliothecaire")
public class Bibliothecaire extends Compte{
	private String nom;
	private String prenom;
	
	
	public Bibliothecaire() {
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}