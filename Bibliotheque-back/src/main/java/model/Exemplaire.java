package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="exemplaire")
public class Exemplaire extends Livre{

	private boolean disponible;
	
	public Exemplaire() {
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
