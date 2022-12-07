package model;

import java.time.LocalDate;
import java.util.List;

public class Inscrit extends Compte{
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private LocalDate finAbonnement;
	private boolean estAbonne;
	private LocalDate inscription;
	private List<Emprunt> historique;
	private boolean estBloque;
	
	public Inscrit() {
	}
	
	
	public Inscrit(String login, String password, String nom, String prenom, LocalDate naissance) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.finAbonnement = null;
		this.estAbonne = false;
	}
	
	public Inscrit(String login, String password, String nom, String prenom, LocalDate naissance,
			LocalDate finAbonnement) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.finAbonnement = finAbonnement;
		this.estAbonne = finAbonnement.isAfter(LocalDate.now());
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
	public LocalDate getFinAbonnement() {
		return finAbonnement;
	}
	public void setFinAbonnement(LocalDate finAbonnement) {
		this.finAbonnement = finAbonnement;
	}
	public boolean isEstAbonne() {
		return estAbonne;
	}
	public void setEstAbonne(boolean estAbonne) {
		this.estAbonne = estAbonne;
	}

	public LocalDate getinscription() {
		return inscription;
	}

	public void setinscription(LocalDate inscription) {
		this.inscription = inscription;
	}

	public List<Emprunt> getHistorique() {
		return historique;
	}

	public void setHistorique(List<Emprunt> historique) {
		this.historique = historique;
	}

	public boolean isEstBloque() {
		return estBloque;
	}

	public void setEstBloque(boolean estBloque) {
		this.estBloque = estBloque;
	}
}
