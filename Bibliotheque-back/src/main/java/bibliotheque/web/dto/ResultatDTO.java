package bibliotheque.web.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class ResultatDTO {

	@JsonView(Views.ViewBase.class)
	private Integer idLivre;

	@JsonView(Views.ViewBase.class)
	private String titre;

	@JsonView(Views.ViewResultatsDTO.class)
	private String auteurs;

	@JsonView(Views.ViewResultatsDTO.class)
	private String genres;

	@JsonView(Views.ViewBase.class)
	private Boolean livreDispo;

	@JsonView(Views.ViewBase.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate publication;
	
	@JsonView(Views.ViewBase.class)
	private List<Eddy> editions = new ArrayList<Eddy>();

	public class Eddy {
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
		private Integer nombreEditionDispo;

		public Eddy() {
		}

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

		public Integer getNombreEditionDispo() {
			return nombreEditionDispo;
		}

		public void setNombreEditionDispo(Integer nombreEditionDispo) {
			this.nombreEditionDispo = nombreEditionDispo;
		}
	}

	public ResultatDTO() {
	}

	public Integer getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(String auteurs) {
		this.auteurs = auteurs;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public Boolean getLivreDispo() {
		return livreDispo;
	}

	public void setLivreDispo(Boolean livreDispo) {
		this.livreDispo = livreDispo;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	public List<Eddy> getEditions() {
		return editions;
	}

	public void setEditions(List<Eddy> editions) {
		this.editions = editions;
	}
}

