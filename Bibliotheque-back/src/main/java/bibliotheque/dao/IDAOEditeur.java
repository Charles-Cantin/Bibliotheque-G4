package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Editeur;

public interface IDAOEditeur extends JpaRepository<Editeur, Integer>{

}
