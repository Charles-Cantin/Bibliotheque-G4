package bibliotheque.web.dto;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class EditionDTO {
	
	// from Edition
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
	// from Livre
	@JsonView(Views.ViewBase.class)
	private String titre;
	@JsonView(Views.ViewBase.class)
	private String resume;
	@JsonView(Views.ViewBase.class)
	private Integer anneeParution;
	// from others (just get 1 property)
	@JsonView(Views.ViewBase.class)
	private String nomsAuteurs;
	@JsonView(Views.ViewBase.class)
	private String nomEditeur;
	@JsonView(Views.ViewBase.class)
	private String nomsGenres;
	
	public EditionDTO() {}

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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Integer getAnneeParution() {
		return anneeParution;
	}

	public void setAnneeParution(Integer anneeParution) {
		this.anneeParution = anneeParution;
	}

	public String getNomsAuteurs() {
		return nomsAuteurs;
	}

	public void setNomsAuteurs(String nomsAuteurs) {
		this.nomsAuteurs = nomsAuteurs;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	public String getNomsGenres() {
		return nomsGenres;
	}

	public void setNomsGenres(String nomsGenres) {
		this.nomsGenres = nomsGenres;
	}

	@Override
	public String toString() {
		return "EditionDTO [ISBN=" + ISBN + ", pages=" + pages + ", format=" + format + ", langue=" + langue
				+ ", titre=" + titre + ", resume=" + resume + ", anneeParution=" + anneeParution + ", nomsAuteurs="
				+ nomsAuteurs + ", nomEditeur=" + nomEditeur + ", nomsGenres=" + nomsGenres + "]";
	}
}

