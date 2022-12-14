package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="auteur")
public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_auteur")
	private Integer id;
	private String nom;
	private String prenom;
	private LocalDate naissance;
	
	@ManyToMany
	@JoinTable(
			name="auteur_oeuvre",
			joinColumns = @JoinColumn(referencedColumnName="id_auteur"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id_oeuvre"))
	private List<Oeuvre> oeuvres;
	
	public Auteur() {
	}
	
	public Auteur(String nom, String prenom, LocalDate naissance, List<Oeuvre> oeuvres) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.oeuvres = oeuvres;
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
	public List<Oeuvre> getOeuvres() {
		return oeuvres;
	}
	public void setOeuvres(List<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}
	
}
