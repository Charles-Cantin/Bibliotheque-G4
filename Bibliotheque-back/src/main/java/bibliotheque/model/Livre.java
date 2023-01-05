package bibliotheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views.ViewBase;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(ViewBase.class)
	private Integer id;
	@JsonView(ViewBase.class)
	private String titre;
	@JsonView(ViewBase.class)
	private int parutionAnnee;
	@JsonView(ViewBase.class)
	private LocalDate parution;
	
	/* À PROPOS DE LA POSSESSION D'UNE RELATION BIDIRECTIONNELLE
	 * Bien que la relation soit bidirectionnelle,il existe en fait
	 * une notion de "possession" de la relation : le possesseur est
	 * le seul qui puisse mettre à jour la table de jointure.
	 * 
	 * Exemple pour nous : si on crée un Livre et un Auteur, qu'on
	 * assigne le Livre à l'Auteur comme attribut, et qu'on save l'Auteur,
	 * LA TABLE DE JOINTURE NE SE METTRA PAS À JOUR.
	 * Si on fait l'inverse (Auteur attribut de Livre), et qu'on save le Livre,
	 * LA TABLE DE JOINTURE SE METTRA À JOUR.
	 * 
	 * Exemple réel sur SO :
	 * https://stackoverflow.com/questions/38036165/jpa-manytomany-does-not-insert-into-join-table-when-create/38037771#38037771
	 * 
	 * J'ai (Picoma) décidé unilatéralement de centraliser la possession
	 * des relations bidirectionnelles ManyToMany sur Livre : c'est probablement
	 * l'objet qu'on manipulera le plus, et mettre à jour cet objet
	 * mettra à jour toutes ses relations, comme ça on devrait être
	 * tranquille. J'espère.*/
	
	// nice  -Charles
	
	@ManyToMany
	@JoinTable(
			name="join_livre_auteur",
			joinColumns = @JoinColumn(name = "id_livre"),
			inverseJoinColumns = @JoinColumn(name = "id_auteur"))
	private List<Auteur> auteurs = new ArrayList<Auteur>();
	
	@ManyToMany
	@JoinTable(
			name="join_livre_genre",
			joinColumns = @JoinColumn(name = "id_livre"),
			inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private List<Genre> genres = new ArrayList<Genre>();
	
	// Lui n'est pas centralisé : la possession est imposée (car OneToMany)
	@OneToMany(mappedBy = "livre")
	private List<Edition> editions = new ArrayList<Edition>();
	
	public Livre() {
	}

	
	public Livre(String titre, int parutionAnnee, LocalDate parution, List<Auteur> auteurs, List<Genre> genres,
			List<Edition> editions) {
		this.titre = titre;
		this.parutionAnnee = parutionAnnee;
		this.parution = parution;
		this.auteurs = auteurs;
		this.genres = genres;
		this.editions = editions;
	}

	public Livre(String titre, int parutionAnnee, LocalDate parution, Auteur auteur, Genre genre,
			Edition edition) {
		this.titre = titre;
		this.parutionAnnee = parutionAnnee;
		this.parution = parution;
		this.auteurs.add(auteur);
		this.genres.add(genre);
		this.editions.add(edition);
	}
	
	public Livre(String titre, int parutionAnnee, Auteur auteur, Genre genre,
			Edition edition) {
		this.titre = titre;
		this.parutionAnnee = parutionAnnee;
		this.parution = LocalDate.ofYearDay(parutionAnnee, 1);
		this.auteurs.add(auteur);
		this.genres.add(genre);
		this.editions.add(edition);
	}
	
	public Livre(String titre, LocalDate parution, Auteur auteur, Genre genre,
			Edition edition) {
		this.titre = titre;
		this.parutionAnnee = parution.getYear();
		this.parution = parution;
		this.auteurs.add(auteur);
		this.genres.add(genre);
		this.editions.add(edition);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getParutionAnnee() {
		return parutionAnnee;
	}

	public void setParutionAnnee(int parutionAnnee) {
		this.parutionAnnee = parutionAnnee;
	}

	public LocalDate getParution() {
		return parution;
	}

	public void setParution(LocalDate parution) {
		this.parution = parution;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Edition> getEditions() {
		return editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", parutionAnnee=" + parutionAnnee + ", parution=" + parution
				+ ", auteurs=" + auteurs + ", genres=" + genres + "]";
	}
	
}