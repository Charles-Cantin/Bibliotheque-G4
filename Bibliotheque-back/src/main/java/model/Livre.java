package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre extends Oeuvre {

	protected String edition;
	protected String isbn;
	
	@ManyToOne
	@JoinColumn(name="id_editeur")
	protected Editeur editeur;
	
	
	public Livre() {
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