package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Edition;
import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

}
