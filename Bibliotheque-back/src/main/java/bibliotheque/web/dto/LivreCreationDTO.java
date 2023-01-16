package bibliotheque.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class LivreCreationDTO {
	
	@JsonView(Views.ViewBase.class)
	private String titre;
	
	@JsonView(Views.ViewLivreDTO.class)
	private Integer auteurs;
	
	@JsonView(Views.ViewLivreDTO.class)
	private String resume;
	
	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate publication;

    public LivreCreationDTO() {}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Integer auteurs) {
		this.auteurs = auteurs;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	
}

