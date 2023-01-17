package bibliotheque.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class AjoutEmpruntDTO {
	
	@JsonView(Views.ViewBase.class)
	private Integer idEmprunteur;
	
	@JsonView(Views.ViewBase.class)
	private Integer idExemplaire;
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate debut;
	
	
    public AjoutEmpruntDTO() {}


	public Integer getIdEmprunteur() {
		return idEmprunteur;
	}


	public void setIdEmprunteur(Integer idEmprunteur) {
		this.idEmprunteur = idEmprunteur;
	}


	public Integer getIdExemplaire() {
		return idExemplaire;
	}


	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	



}

