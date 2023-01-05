package bibliotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="exemplaire")
public class Exemplaire{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private boolean disponible;
	
	@ManyToOne
	@JsonView(Views.ViewExemplaire.class)
	private Edition edition;
	
	public Exemplaire() {}
	
	

	public Exemplaire(Edition edition, boolean disponible) {
		this.disponible = disponible;
		this.edition = edition;
	}
	
	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Exemplaire [id=" + id + ", disponible=" + disponible + ", edition=" + edition + "]";
	}
}
