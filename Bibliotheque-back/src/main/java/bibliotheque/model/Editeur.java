package bibliotheque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editeur")
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;

	@OneToMany(mappedBy = "editeur")
	private List<Edition> edition;

	public Editeur() {}

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

	public List<Edition> getEdition() {
		return edition;
	}

	public void setEdition(List<Edition> edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Editeur [id=" + id + ", nom=" + nom + "]";
	}
}
