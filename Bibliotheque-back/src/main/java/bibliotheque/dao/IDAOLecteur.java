package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Lecteur;

public interface IDAOLecteur extends JpaRepository<Lecteur,Integer>{
}