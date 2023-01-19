package bibliotheque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bibliothecaire")
public class Bibliothecaire extends Compte{
	
	public Bibliothecaire() {
	}
	
	
}