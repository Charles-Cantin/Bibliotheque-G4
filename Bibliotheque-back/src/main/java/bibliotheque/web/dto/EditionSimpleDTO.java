package bibliotheque.web.dto;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class EditionSimpleDTO {
	
	@JsonView(Views.ViewBase.class)
	private Integer idEdition;
	@JsonView(Views.ViewBase.class)
	private String ISBN;
	@JsonView(Views.ViewBase.class)
	private Integer pages;
	@JsonView(Views.ViewBase.class)
	private String format;
	@JsonView(Views.ViewBase.class)
	private String langue;
	@JsonView(Views.ViewBase.class)
	private String nomEditeur;
	@JsonView(Views.ViewBase.class)
	private Boolean disponibilite;
	
	public EditionSimpleDTO() {}

	public Integer getIdEdition() {
		return idEdition;
	}

	public void setIdEdition(Integer idEdition) {
		this.idEdition = idEdition;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	public Boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

}

