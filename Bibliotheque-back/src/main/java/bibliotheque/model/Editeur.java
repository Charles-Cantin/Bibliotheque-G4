package bibliotheque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editeur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nom;
		
		@OneToMany(mappedBy = "editeur")
		private List<Edition> edition;
		
		public Editeur() {
			// TODO Auto-generated constructor stub
		}
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public List<Edition> getLivre() {
			return edition;
		}
		public void setLivre(List<Edition> edition) {
			this.edition = edition;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<Edition> getEdition() {
			return edition;
		}

		public void setEdition(List<Edition> edition) {
			this.edition = edition;
		}
}
