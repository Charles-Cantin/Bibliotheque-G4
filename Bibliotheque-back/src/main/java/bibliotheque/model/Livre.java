package bibliotheque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="oeuvre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_oeuvre")
	protected Integer id;
	protected String titre;
	protected int parutionAnnee;
	protected LocalDate parution;
	
	@ManyToMany
	protected List<Auteur> auteurs;
	
	@ManyToMany
	protected List<Genre> genres;
	
	@OneToMany(mappedBy = "livre")
	private List<Edition> editions;
	
	public Livre() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getParutionAnnee() {
		return parutionAnnee;
	}

	public void setParutionAnnee(int parutionAnnee) {
		this.parutionAnnee = parutionAnnee;
	}

	public LocalDate getParution() {
		return parution;
	}

	public void setParution(LocalDate parution) {
		this.parution = parution;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Edition> getEditions() {
		return editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}
	


}