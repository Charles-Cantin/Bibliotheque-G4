package bibliotheque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views.ViewBase;

@Entity
@DiscriminatorValue("bibliothecaire")
public class Bibliothecaire extends Compte{
		
	
	@JsonView(ViewBase.class)
	private String nom;
	@JsonView(ViewBase.class)
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