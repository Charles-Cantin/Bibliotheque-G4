package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Emprunt;

public interface IDAOEmprunt extends JpaRepository<Emprunt, Integer>{
	// find by emprunteur
	// find by exemplaire
	// trouver emprunts en cours
}
