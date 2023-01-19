package bibliotheque.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class ExemplaireByEditionDTO {
	
	// from Exemplaire
	@JsonView(Views.ViewBase.class)
	private Integer idExemplaire;
	@JsonView(Views.ViewBase.class)
	private boolean emprunted; // TODO remove ; use dateProchaineDispo
	// from Editeur
	@JsonView(Views.ViewBase.class)
	private String nomEditeur;
	// from Emprunts (TODO)
	@JsonView(Views.ViewBase.class)
	private LocalDate dateProchaineDispo;
	
	public ExemplaireByEditionDTO() {}


	@Override
	public String toString() {
		return "ExemplaireByEditionDTO [idExemplaire=" + idExemplaire + ", disponible=" + emprunted + ", nomEdition="
				+ nomEditeur + ", dateProchaineDispo=" + dateProchaineDispo + "]";
	}


	public Integer getIdExemplaire() {
		return idExemplaire;
	}


	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}


	public String getNomEditeur() {
		return nomEditeur;
	}


	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}


	public LocalDate getDateProchaineDispo() {
		return dateProchaineDispo;
	}


	public void setDateProchaineDispo(LocalDate dateProchaineDispo) {
		this.dateProchaineDispo = dateProchaineDispo;
	}


	public boolean isEmprunted() {
		return emprunted;
	}


	public void setEmprunted(boolean emprunted) {
		this.emprunted = emprunted;
	}
	
}

