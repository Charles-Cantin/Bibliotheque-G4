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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	@NotBlank(message= "Date de début obligatoire")
	private LocalDate debut;
	@JsonView(Views.ViewBase.class)
	@NotBlank(message= "Date de fin obligatoire")
	private LocalDate fin;
	@JsonView(Views.ViewBase.class)
	private LocalDate dateRendu;

	@OneToOne
	@JsonView(Views.ViewEmprunt.class)
	@NotNull(message = "exemplaire obligatoire")
	private Exemplaire exemplaire;
	
	@ManyToOne
	@JoinColumn(name="id_emprunteur")
	@JsonView(Views.ViewEmprunt.class)
	@NotNull(message = "emprunteur obligatoire")
	private Lecteur emprunteur;
	
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

	public Lecteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Lecteur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public LocalDate getDateRendu() {
		return dateRendu;
	}

	public void setDateRendu(LocalDate dateRendu) {
		this.dateRendu = dateRendu;
	}
	
}