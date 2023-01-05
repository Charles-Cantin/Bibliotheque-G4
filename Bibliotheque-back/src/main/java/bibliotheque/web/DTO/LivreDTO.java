package bibliotheque.web.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Auteur;

import bibliotheque.model.Views;

public class LivreDTO {
	@JsonView(Views.ViewBase.class)
	@JsonProperty("Titre")
	private String titre;
	@JsonView(Views.ViewLivre.class)
	@JsonProperty("Auteurs")
	private List<Auteur> auteurs = new ArrayList<Auteur>();
	
	@JsonView(Views.ViewBase.class)
	@JsonProperty("Disponibilité")
	private Boolean disponibilité;
	
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate publication;

    public LivreDTO() {}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Boolean getDisponibilité() {
		return disponibilité;
	}

	public void setDisponibilité(Boolean disponibilité) {
		this.disponibilité = disponibilité;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	
	
	
	

}

