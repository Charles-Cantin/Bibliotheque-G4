package bibliotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="exemplaire")
public class Exemplaire{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private boolean emprunted;
	@JsonView(Views.ViewBase.class)
	private boolean reserved;
	
	@ManyToOne
	@JsonView(Views.ViewExemplaire.class)
	@NotNull
	private Edition edition;
	
	public Exemplaire() {}
	
	public Exemplaire(Edition ed1, boolean disponible) {
		this.edition = ed1;
		this.emprunted = !disponible;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isEmprunted() {
		return emprunted;
	}

	public void setEmprunted(boolean emprunted) {
		this.emprunted = emprunted;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	
	@Override
	public String toString() {
		return "Exemplaire [id=" + id + ", emprunted=" + emprunted + ", reserved=" + reserved + ", edition=" + edition
				+ "]";
	}

}
