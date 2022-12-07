package model;

import java.time.LocalDate;

public class Emprunt {
	private Integer id;
	private Livre livre;
	private LocalDate debut;
	private int dureeJours;
	private LocalDate finEffective;
	private boolean rendu;
	
	public Emprunt() {
	}
	
	
	public Emprunt(LocalDate debut, Livre livre) {
		this.debut = debut;
		this.livre = livre;
		this.dureeJours = 21;
		this.finEffective = null;
		this.rendu = false;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	public int getDureeJours() {
		return dureeJours;
	}


	public void setDureeJours(int dureeJours) {
		this.dureeJours = dureeJours;
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


	public Livre getLivre() {
		return livre;
	}


	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
}
