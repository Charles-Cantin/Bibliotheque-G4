package bibliotheque.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;

	@JsonView(Views.ViewBase.class)
	private LocalDate debut;

	@JsonView(Views.ViewBase.class)
	private static int dureeJours = 21;

	@JsonView(Views.ViewBase.class)
	private LocalDate finEffective;

	@JsonView(Views.ViewBase.class)
	private boolean rendu;

	@OneToOne
//	@JsonView(Views.ViewBase.class)
	private Exemplaire exemplaire;
	
	@ManyToOne
	@JoinColumn(name="id_emprunteur")
	private Inscrit emprunteur;
	
	public Emprunt() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public static int getDureeJours() {
		return dureeJours;
	}

	public static void setDureeJours(int dureeJours) {
		Emprunt.dureeJours = dureeJours;
	}

	public LocalDate getFinEffective() {
		return finEffective;
	}

	public void setFinEffective(LocalDate finEffective) {
		this.finEffective = finEffective;
	}

	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}

	public Inscrit getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Inscrit emprunteur) {
		this.emprunteur = emprunteur;
	}
	
}