package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Livre;

public interface IDAOLivre extends JpaRepository<Livre,Integer>{
	// find all by auteurs / auteur ?
	// find all by genres / genre ?
	// find by (chaque attribut)
	
}
