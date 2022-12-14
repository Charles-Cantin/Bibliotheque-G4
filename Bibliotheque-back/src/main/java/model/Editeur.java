package model;

import java.util.List;

import javax.persistence.OneToMany;

public class Editeur {
		private String nom;
		@OneToMany(mappedBy = "editeur")
		private List<Livre> Livre;
		
		public Editeur() {
			// TODO Auto-generated constructor stub
		}
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public List<Livre> getLivre() {
			return Livre;
		}
		public void setLivre(List<Livre> livre) {
			Livre = livre;
		}
}
