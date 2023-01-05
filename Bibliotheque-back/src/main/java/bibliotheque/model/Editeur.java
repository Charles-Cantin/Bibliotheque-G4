package bibliotheque.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "editeur")
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@JsonView(Views.ViewBase.class)
	private String nom;

	@OneToMany(mappedBy = "editeur")
	@JsonView(Views.ViewEditeurDetail.class)
	private List<Edition> editions = new ArrayList<Edition>();

	public Editeur() {}
	
	public Editeur(String nom) {
		this.nom = nom;
	}

	public Editeur(String nom, List<Edition> editions) {
		this.nom = nom;
		this.editions = editions;
	}
	
	public Editeur(String nom, Edition edition) {
		this.nom = nom;
		this.editions.add(edition);
	}
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Edition> getEditions() {
		return editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}

	@Override
	public String toString() {
		return "Editeur [id=" + id + ", nom=" + nom + "]";
	}
}
