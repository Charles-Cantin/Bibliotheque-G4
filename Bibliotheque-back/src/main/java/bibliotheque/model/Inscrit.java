package bibliotheque.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("inscrit")
public class Inscrit extends Compte{
	
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private LocalDate finAbonnement;
	private boolean blocked;
	
	@OneToMany(mappedBy="emprunteur")
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	public Inscrit() {
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

	public List<Emprunt> getHistorique() {
		return emprunts;
	}

	public void setHistorique(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
