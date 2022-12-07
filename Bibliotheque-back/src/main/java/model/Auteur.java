package model;

import java.time.LocalDate;
import java.util.List;

public class Auteur {
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private List<Livre> oeuvres;
	
	public Auteur() {
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
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public List<Livre> getOeuvres() {
		return oeuvres;
	}
	public void setOeuvres(List<Livre> oeuvres) {
		this.oeuvres = oeuvres;
	}
	
}
