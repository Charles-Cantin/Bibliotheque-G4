package bibliotheque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views.ViewBase;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte{
	
	@JsonView(ViewBase.class)
	private String nom;
	@JsonView(ViewBase.class)
	private String prenom;
	
	
	public Admin() {
	}

}
