package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate debut;
	private static int dureeJours = 21;
	private LocalDate finEffective;
	private boolean rendu;
	

	@OneToOne
	private Exemplaire exemplaire;
	
	@ManyToOne
	@JoinColumn(name="id_emprunteur")
	private Inscrit emprunteur;
	
	public Emprunt() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public static int getDureeJours() {
		return dureeJours;
	}

	public static void setDureeJours(int dureeJours) {
		Emprunt.dureeJours = dureeJours;
	}

	public LocalDate getFinEffective() {
		return finEffective;
	}

	public void setFinEffective(LocalDate finEffective) {
		this.finEffective = finEffective;
	}

	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}

	public Inscrit getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Inscrit emprunteur) {
		this.emprunteur = emprunteur;
	}
	
}