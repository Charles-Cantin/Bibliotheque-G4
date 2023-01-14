package bibliotheque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="editions")
public class Edition{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private String isbn;
	@JsonView(Views.ViewBase.class)
	private String format;
	@JsonView(Views.ViewBase.class)
	private String langue;
	@JsonView(Views.ViewBase.class)
	private Integer pages;
	
	@ManyToOne
	@JoinColumn(name="id_editeur")
	@JsonView(Views.ViewEdition.class)
	private Editeur editeur;
	
	@ManyToOne
	@JsonView(Views.ViewEdition.class)
	private Livre livre;
	
	@OneToMany(mappedBy = "edition")
	@JsonView(Views.ViewEditionDetail.class)
	private List<Exemplaire> exemplaires;
		
	public Edition() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	@Override
	public String toString() {
		return "Edition [id=" + id + ", isbn=" + isbn + ", format=" + format + ", langue=" + langue + ", pages=" + pages
				+ ", editeur=" + editeur + ", exemplaires=" + exemplaires + "]";
	}
}