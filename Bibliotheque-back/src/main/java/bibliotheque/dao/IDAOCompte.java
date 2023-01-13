package bibliotheque.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bibliotheque.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{
	
	@Query("Select c from Compte c where c.login = :login and c.password = :password")
	public Optional<Compte> findByLoginAndPassword(String login, String password);
}