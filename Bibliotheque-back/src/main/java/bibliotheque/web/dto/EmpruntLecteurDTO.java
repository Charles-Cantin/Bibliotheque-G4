package bibliotheque.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class EmpruntLecteurDTO {
	
	@JsonView(Views.ViewBase.class)
	private Integer idExemplaire;
	
	@JsonView(Views.ViewBase.class)
	private String titreLivre;
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate debut;
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fin;
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateRendu;
	
    public EmpruntLecteurDTO() {}


	public Integer getIdExemplaire() {
		return idExemplaire;
	}


	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}


	public String getTitreLivre() {
		return titreLivre;
	}


	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	public LocalDate getFin() {
		return fin;
	}


	public void setFin(LocalDate fin) {
		this.fin = fin;
	}


	public LocalDate getDateRendu() {
		return dateRendu;
	}


	public void setDateRendu(LocalDate dateRendu) {
		this.dateRendu = dateRendu;
	}


}

