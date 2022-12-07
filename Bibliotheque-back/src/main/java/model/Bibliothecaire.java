package model;

public class Bibliothecaire extends Compte{
	private String nom;
	private String prenom;
	
	
	public Bibliothecaire() {
	}


	public Bibliothecaire(String login, String password, String nom, String prenom) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
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