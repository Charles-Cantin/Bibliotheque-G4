package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{
	//find by login and password
}
