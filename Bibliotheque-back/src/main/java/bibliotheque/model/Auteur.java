package bibliotheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="auteur")
public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private String nom;
	@JsonView(Views.ViewBase.class)
	private String prenom;
	@JsonView(Views.ViewBase.class)
	private LocalDate naissance;
	
	@ManyToMany(mappedBy = "auteurs")
	private List<Livre> livres = new ArrayList<Livre>();
	
	public Auteur() {
	}
	
	public Auteur(String nom, String prenom, LocalDate naissance, List<Livre> livres) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.livres = livres;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
	}
	
}
