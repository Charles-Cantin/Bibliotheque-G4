package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Auteur;

public interface IDAOAuteur extends JpaRepository<Auteur,Integer>{
}
