package model;

import java.time.LocalDate;
import java.util.List;

public class Livre {
	
	private String titre;
	private List<Auteur> auteurs;
	private LocalDate parution;
	private List<Genre> genres;
	private String edition;
	private Editeur editeur;
	private String isbn;
	
	public Livre() {
	}

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

	public LocalDate getParution() {
		return parution;
	}

	public void setParution(LocalDate parution) {
		this.parution = parution;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}